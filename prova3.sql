CREATE DATABASE siga;
GO
use siga;
GO
DROP TABLE aluno;
GO
CREATE TABLE aluno (
	ra char(13),
	nome VARCHAR(255),
	PRIMARY KEY (ra)
)
GO
DROP TABLE avaliacao;
GO
CREATE TABLE avaliacao (
	codigo INT,
	tipo VARCHAR(255),
	PRIMARY KEY (codigo)
)
GO
DROP TABLE disciplina;
GO
CREATE TABLE disciplina (
	codigo VARCHAR(255),
	nome VARCHAR(255),
	sigla VARCHAR(10),
  turno VARCHAR(255),
  num_aulas INT,
	PRIMARY KEY (codigo)
)
GO
DROP TABLE notas;
GO
CREATE TABLE notas (
	ra_aluno char(13),
	codigo_disciplina VARCHAR(255),
	codigo_avaliacao INT,
	nota DECIMAL,
	FOREIGN KEY (ra_aluno) REFERENCES aluno(ra),
	FOREIGN KEY (codigo_disciplina) REFERENCES disciplina(codigo),
	FOREIGN KEY (codigo_avaliacao) REFERENCES avaliacao(codigo)
)
GO
DROP TABLE faltas;
GO
CREATE TABLE faltas (
	ra_aluno char(13),
	codigo_disciplina VARCHAR(255),
	data DATETIME,
	presenca INT,
	FOREIGN KEY (ra_aluno) REFERENCES aluno(ra),
	FOREIGN KEY (codigo_disciplina) REFERENCES disciplina(codigo)
)
GO
CREATE TABLE matricula (
codigo_disciplina		VARCHAR(255)			NOT NULL,
ra_aluno				CHAR(13)	NOT NULL
PRIMARY KEY(ra_aluno, codigo_disciplina)
FOREIGN KEY(ra_aluno) REFERENCES aluno(ra),
FOREIGN KEY(codigo_disciplina) REFERENCES disciplina(codigo)
)
GO
INSERT INTO disciplina VALUES
('4203-010', 'Arquitetura e Organização de Computadores', 'AOC', 'tarde', 80),
('4203-020', 'Arquitetura e Organização de Computadores', 'AOC', 'noite', 80),
('4208-010', 'Laboratório de Hardware', 'LBH', 'tarde', 80),
('4226-004', 'Banco de Dados', 'BD', 'tarde', 80),
('4233-005', 'Laboratorio de Banco de Dados', 'LBD', 'tarde', 80),
('5005-220', 'Métodos Para a Produção do Conhecimento', 'MPC', 'manha', 40);
INSERT INTO avaliacao VALUES(1,'P1'), (2,'P2'),(3,'P3'),(4,'PE'),(5,'EX');
INSERT INTO aluno VALUES
('1110482012001', 'Marielle'),
('1110482012002', 'Milton'),
('1110482012003', 'Marje'),
('1110482012004', 'Emlyn'),
('1110482012005', 'Fee'),
('1110482012006', 'Charles'),
('1110482012007', 'Octavius'),
('1110482012008', 'Nicki'),
('1110482012009', 'Gael'),
('1110482012010', 'Naoma'),
('1110482012011', 'Jorgan'),
('1110482012012', 'Deane'),
('1110482012013', 'Ricki'),
('1110482012014', 'Pebrook'),
('1110482012015', 'Domenico'),
('1110482012016', 'Martainn'),
('1110482012017', 'Nester'),
('1110482012018', 'Brantley'),
('1110482012019', 'Kimberlyn'),
('1110482012020', 'Bay')
GO
CREATE FUNCTION notas_turma(@codigo_disciplina VARCHAR(255)) 
RETURNS @table TABLE(ra_aluno INT, nome_aluno VARCHAR(255), nota1 DECIMAL, nota2 DECIMAL, nota3 DECIMAL, nota4 DECIMAL, nota5 DECIMAL, media_final DECIMAL, situacao VARCHAR(100))
AS 
BEGIN
	
	RETURN;
END
GO
CREATE FUNCTION presencas(@presenca INT, @total INT)
RETURNS VARCHAR(4) AS
BEGIN
	DECLARE @pf VARCHAR(4)
	IF @total = 80 BEGIN
		SELECT @pf = CONCAT(REPLICATE('P',4-@presenca),REPLICATE('F', @presenca))
	END
	ELSE
	BEGIN
		SELECT @pf = CONCAT(REPLICATE('P',2-@presenca),REPLICATE('F', @presenca))
	END
	RETURN @pf;
END
GO
CREATE FUNCTION calcula_faltas(@ra CHAR(13), @disciplina VARCHAR(255))
RETURNS INT
AS
BEGIN
	DECLARE @faltas INT = 0;
	SELECT @faltas = SUM(presenca) FROM faltas WHERE codigo_disciplina = @disciplina AND ra_aluno = @ra
	RETURN @faltas;
END
GO
DROP FUNCTION faltas_turma;
GO
CREATE FUNCTION faltas_turma(@codigo_disciplina VARCHAR(255)) 
RETURNS @table TABLE(RA_Aluno CHAR(13), Nome_Aluno VARCHAR(255), Data1 VARCHAR(255), Data2 VARCHAR(255),Data3 VARCHAR(255),Data4 VARCHAR(255),Data5 VARCHAR(255),Data6 VARCHAR(255),Data7 VARCHAR(255),Data8 VARCHAR(255), Data9 VARCHAR(255), Data10 VARCHAR(255), Data11 VARCHAR(255), Data12 VARCHAR(255), Data13 VARCHAR(255), Data14 VARCHAR(255), Data15 VARCHAR(255), Data16 VARCHAR(255), Data17 VARCHAR(255), Data18 VARCHAR(255), Data19 VARCHAR(255), Data20 VARCHAR(255), Total_Faltas INT, Debug VARCHAR(255))
AS
BEGIN
	DECLARE @ra CHAR(13)
	DECLARE @name VARCHAR(255)
	DECLARE @data DATETIME
	DECLARE @presenca INT
	DECLARE @num_aulas INT
	DECLARE @pf VARCHAR(4)
	DECLARE @total INT
	SELECT @num_aulas = num_aulas FROM disciplina WHERE disciplina.codigo = @codigo_disciplina
	DECLARE @t TABLE (RA_Aluno CHAR(13), Nome_Aluno VARCHAR(255), Data1 VARCHAR(255), Data2 VARCHAR(255),Data3 VARCHAR(255),Data4 VARCHAR(255),Data5 VARCHAR(255),Data6 VARCHAR(255),Data7 VARCHAR(255),Data8 VARCHAR(255), Data9 VARCHAR(255), Data10 VARCHAR(255), Data11 VARCHAR(255), Data12 VARCHAR(255), Data13 VARCHAR(255), Data14 VARCHAR(255), Data15 VARCHAR(255), Data16 VARCHAR(255), Data17 VARCHAR(255), Data18 VARCHAR(255), Data19 VARCHAR(255), Data20 VARCHAR(255), Total_Faltas INT, Debug VARCHAR(255))
	DECLARE cursor_faltas CURSOR
	FOR SELECT faltas.ra_aluno, nome, data, presenca FROM faltas INNER JOIN aluno ON faltas.ra_aluno = aluno.ra INNER JOIN matricula ON matricula.codigo_disciplina = @codigo_disciplina AND aluno.ra = matricula.ra_aluno WHERE faltas.codigo_disciplina = @codigo_disciplina ORDER BY faltas.data
	OPEN cursor_faltas
	FETCH NEXT FROM cursor_faltas INTO @ra, @name, @data, @presenca

	WHILE @@FETCH_STATUS = 0
	BEGIN
	DECLARE @exists INT
	SELECT @exists = COUNT(*) FROM @table WHERE RA_Aluno = @ra
	INSERT INTO @t SELECT * FROM @table WHERE RA_Aluno = @ra	
	SELECT @pf = dbo.presencas(@presenca, @num_aulas);
	SELECT @total = dbo.calcula_faltas(@ra, @codigo_disciplina);
	IF @exists = 0 BEGIN
		INSERT INTO @table VALUES(@ra, @name, @pf,NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL, @total, '');
	END
	ELSE
	BEGIN
		DECLARE @col VARCHAR(255);
		SELECT @col =  (case when Data2 is null then 'Data2'
             when Data3 is null then 'Data3'
             when Data4 is null then 'Data4'
			 when Data5 is null then 'Data5'
			 when Data6 is null then 'Data6'
			 when Data7 is null then 'Data7'
			 when Data8 is null then 'Data8'
			 when Data9 is null then 'Data9'
			 when Data10 is null then 'Data10'
			 when Data11 is null then 'Data11'
			 when Data12 is null then 'Data12'
			 when Data13 is null then 'Data13'
			 when Data14 is null then 'Data14'
			 when Data15 is null then 'Data15'
			 when Data16 is null then 'Data16'
			 when Data17 is null then 'Data17'
			 when Data18 is null then 'Data18'
			 when Data19 is null then 'Data19'
			 when Data20 is null then 'Data20'
        end) FROM @table WHERE RA_Aluno = @ra;
		UPDATE @table SET Debug = @pf;

		if @col = 'Data2' BEGIN
			UPDATE @table SET Data2 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data3' BEGIN
			UPDATE @table SET Data3 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data4' BEGIN
			UPDATE @table SET Data4 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data5' BEGIN
			UPDATE @table SET Data5 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data6' BEGIN
			UPDATE @table SET Data6 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data7' BEGIN
			UPDATE @table SET Data7 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data8' BEGIN
			UPDATE @table SET Data8 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data9' BEGIN
			UPDATE @table SET Data9 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data10' BEGIN
			UPDATE @table SET Data10 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data11' BEGIN
			UPDATE @table SET Data11 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data12' BEGIN
			UPDATE @table SET Data12 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data13' BEGIN
			UPDATE @table SET Data13 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data14' BEGIN
			UPDATE @table SET Data14 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data15' BEGIN
			UPDATE @table SET Data15 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data16' BEGIN
			UPDATE @table SET Data16 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data17' BEGIN
			UPDATE @table SET Data17 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data18' BEGIN
			UPDATE @table SET Data18 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data19' BEGIN
			UPDATE @table SET Data19 = @pf WHERE RA_Aluno = @ra;
		END
		if @col = 'Data20' BEGIN
			UPDATE @table SET Data20 = @pf WHERE RA_Aluno = @ra;
		END
	END
	FETCH NEXT FROM cursor_faltas INTO @ra, @name, @data, @presenca
	END
	CLOSE cursor_faltas
	DEALLOCATE cursor_faltas
	RETURN;
END
GO
SELECT * FROM faltas_turma('4203-010')
GO

create database maesemacao;
use maesemacao;

CREATE TABLE IF NOT EXISTS Endereco (
    id_endereco INTEGER AUTO_INCREMENT PRIMARY KEY,
    cep INTEGER NOT NULL,
    estado VARCHAR(50) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    fk_candidato INTEGER,
    FOREIGN KEY (fk_candidato) REFERENCES Candidato (id_candidato) ON DELETE CASCADE
);

alter table endereco add column fk_empresa INTEGER;
alter table endereco add constraint fk_empresa 
FOREIGN KEY (fk_empresa) REFERENCES Empresa (id_empresa) ON DELETE CASCADE;
    
select * from endereco;
select * from Candidato, Endereco where id_candidato = fk_candidato;
SELECT c.*, e.* FROM endereco e JOIN candidato c on c.id_candidato = 3 and e.fk_candidato = c.id_candidato;

CREATE TABLE IF NOT EXISTS Candidato (
    id_candidato INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    cpf VARCHAR(15) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    idioma VARCHAR(50) NOT NULL,
    formacao VARCHAR(255) NOT NULL
);

select * from candidato;

CREATE TABLE IF NOT EXISTS Empresa (
    id_empresa INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cnpj VARCHAR(18) UNIQUE,
    email VARCHAR(255),
    telefone VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Vaga (
    id_vaga INTEGER AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(1000) NOT NULL,
    requisito VARCHAR(1000) NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    fk_empresa INTEGER,
    FOREIGN KEY (fk_empresa) REFERENCES Empresa (id_empresa) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Experiencia (
    id_experiencia INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome_empresa VARCHAR(255) NOT NULL,
    cargo VARCHAR(100) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    fk_candidato INTEGER,
    FOREIGN KEY (fk_candidato) REFERENCES Candidato (id_candidato) ON DELETE CASCADE ON UPDATE CASCADE
);

select * from experiencia;

CREATE TABLE IF NOT EXISTS Aplicacao (
    id_aplicacao INTEGER AUTO_INCREMENT PRIMARY KEY,
    fk_vaga INTEGER,
    fk_candidato INTEGER,
    data_aplicacao DATE NOT NULL,
    FOREIGN KEY (fk_vaga) REFERENCES Vaga (id_vaga) ON DELETE SET NULL,
    FOREIGN KEY (fk_candidato) REFERENCES Candidato (id_candidato) ON DELETE SET NULL
);

-- Views

CREATE VIEW ViewCandidato AS
SELECT
    c.id_candidato,
    c.nome,
    c.email,
    c.cpf,
    e.nome_empresa,
    e.cargo,
    e.data_inicio,
    e.data_fim
FROM
    Candidato c
    LEFT JOIN Experiencia e ON c.id_candidato = e.fk_candidato;

CREATE VIEW ViewVagas AS
SELECT
    v.id_vaga,
    v.titulo,
    v.descricao,
    v.requisito,
    v.salario,
    e.nome AS nome_empresa,
    e.email AS email_empresa
FROM
    Vaga v
    JOIN Empresa e ON v.fk_empresa = e.id_empresa;

CREATE VIEW ViewCandidatoAndVaga AS
SELECT
    a.id_aplicacao,
    c.nome AS nome_candidato,
    c.email AS email_candidato,
    v.titulo AS titulo_vaga,
    v.descricao AS descricao_vaga,
    a.data_aplicacao
FROM
    Aplicacao a
    JOIN Candidato c ON a.fk_candidato = c.id_candidato
    JOIN Vaga v ON a.fk_vaga = v.id_vaga;

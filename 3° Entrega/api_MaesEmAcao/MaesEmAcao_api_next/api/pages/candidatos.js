import { useEffect, useState } from "react";
import axios from "axios";
import style from '../styles/Home.module.css';
import "bootstrap/dist/css/bootstrap.css";

const Candidatos = () => {
    const [candidatos, setCandidatos] = useState([]);

    useEffect(() => {
        axios
            .get("https://localhost:7179/api/Candidatos")
            .then((response) => {
                setCandidatos(response.data);
            })
            .catch((error) => {
                console.error("Erro ao buscar a lista de candidatos:", error);
            });
    }, []);

    return (
        <div>
            <h1 className="container">Lista de Candidatos</h1>
            <table className="table container">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Email</th>
                        <th>Telefone</th>
                        <th>Data de Nascimento</th>
                        <th>Formação</th>
                        <th>Idioma</th>
                        <th>Qtd de Filhos</th>
                        <th>Endereço</th>
                    </tr>
                </thead>
                <tbody>
                    {candidatos.map((element) => (
                        <tr key={element.id} className={style.tabela}>
                            <td>{element.id}</td>
                            <td>{element.nome}</td>
                            <td>{element.cpf}</td>
                            <td>{element.email}</td>
                            <td>{element.telefone}</td>
                            <td>{element.dataNascimento}</td>
                            <td>{element.formacao}</td>
                            <td>{element.idioma}</td>
                            <td>{element.qtdFilhos}</td>
                            <td>{element.endereco}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default Candidatos;

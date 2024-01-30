import { useEffect, useState } from "react";
import axios from "axios";
import style from '../styles/Home.module.css';
import "bootstrap/dist/css/bootstrap.css";

const Experiencias = () => {
    const [experiencias, setExperiencias] = useState([]);

    useEffect(() => {
        axios
          .get("https://localhost:7179/api/Experiencias")
          .then((response) => {
            setExperiencias(response.data);
          })
          .catch((error) => {
            console.error("Erro ao buscar a lista de Experiencias:", error);
          });
      }, []);

    return (
        <div>

            <h1 className="container">Lista de Experiencias</h1>
            <table className="table container">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome da Empresa</th>
                        <th>Cargo</th>
                        <th>Data Inicial</th>
                        <th>Data Final</th>
                        <th>Id do Candidato</th>
                    </tr>
                </thead>
                {experiencias.map((element) => (
                    <tbody key={element.id}>
                        <tr className={style.tabela}>
                            <td>{element.id}</td>
                            <td>{element.nome}</td>
                            <td>{element.cargo}</td>
                            <td>{element.dataInicio}</td>
                            <td>{element.dataFim}</td>
                            <td>{element.idCandidato}</td>
                        </tr>
                    </tbody>
                ))}
            </table>
        </div>
    );
};

export default Experiencias;

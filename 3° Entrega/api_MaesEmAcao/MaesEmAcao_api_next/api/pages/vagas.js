import { useEffect, useState } from "react";
import axios from "axios";
import style from '../styles/Home.module.css';
import "bootstrap/dist/css/bootstrap.css";

const Vagas = () => {
  const [vagas, setVagas] = useState([]);

  useEffect(() => {
    axios
      .get("https://localhost:7179/api/Vagas")
      .then((response) => {
        setVagas(response.data);
      })
      .catch((error) => {
        console.error("Erro ao buscar a lista de vagas:", error);
      });
  }, []);

  return (
    <div>

      <h1 className="container">Lista de Vagas</h1>
      <table className="table container">
        <thead>
          <tr>
            <th>Id</th>
            <th>Titulo</th>
            <th>Descrição</th>
            <th>Requisitos</th>
            <th>Salário</th>
            <th>Id da Empresa</th>
          </tr>
        </thead>
        {vagas.map((element) => (
          <tbody key={element.id}>
            <tr className={style.tabela}>
              <td>{element.id}</td>
              <td>{element.titulo}</td>
              <td>{element.descricao}</td>
              <td>{element.requisitos}</td>
              <td>{element.salario}</td>
              <td>{element.idEmpresa}</td>
            </tr>
          </tbody>
        ))}
      </table>
    </div>
  );
};

export default Vagas;

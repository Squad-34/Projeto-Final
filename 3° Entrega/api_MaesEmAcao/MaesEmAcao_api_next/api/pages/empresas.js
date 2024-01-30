import { useEffect, useState } from "react";
import axios from "axios";
import style from '../styles/Home.module.css';
import "bootstrap/dist/css/bootstrap.css";

const Empresas = () => {
  const [empresas, setEmpresas] = useState([]);

  useEffect(() => {
    axios
      .get("https://localhost:7179/api/Empresas")
      .then((response) => {
        setEmpresas(response.data);
      })
      .catch((error) => {
        console.error("Erro ao buscar a lista de empresas:", error);
      });
  }, []);

  return (
    <div>

      <h1 className="container">Lista de Empresas</h1>
      <table className="table container">
        <thead>
          <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>CNPJ</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Endereço</th>
          </tr>
        </thead>
        {empresas.map((element) => (
          <tbody key={element.id}>
            <tr className={style.tabela}>
              <td>{element.id}</td>
              <td>{element.nome}</td>
              <td>{element.cnpj}</td>
              <td>{element.email}</td>
              <td>{element.telefone}</td>
              <td>{element.endereco}</td>
            </tr>
          </tbody>
        ))}
      </table>
    </div>
  );
};

export default Empresas;
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';
import PostModal from '../Components/Post';
import api from '../services/api';

export default function Home({ search }) {

  const [contact, setContact] = useState([]);
  const [showModal, setShowModal] = useState(false);


  useEffect(() => {
    api
      .get("/?name=" + search)
      .then((response) => setContact(response.data))
      .catch((err) => {
        console.error("ops! ocorreu um erro " + err);
      });
  }, [search, contact]);

  const handlerDelete = (e, id) => {
    e.preventDefault();
    api.delete("/" + id)
  }

  return (
    <div className="container mx-auto px-2">
      <div className="row-span-full py-6">
        <button className="cursor-pointer btn px-6 py-2 bg-green-600 
      text-white font-medium text-xs leading-tight uppercase rounded 
      shadow-md hover:bg-green-700 hover:shadow-lg focus:bg-green-700  
      focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 
      active:shadow-lg transition duration-150 ease-in-out"
          type="button" id="seacrh" onClick={() => setShowModal(true)}>Adcionar
        </button>
      </div>

      <div className="relative overflow-x-auto shadow-md">
        <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
          <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
              <th scope="col" className="px-6 py-3">Nome</th>
              <th scope="col" className="px-6 py-3">Sobrenome</th>
              <th scope="col" className="px-6 py-3">Email</th>
              <th scope="col" className="px-6 py-3">Cpf</th>
              <th scope="col" className="px-6 py-3">Telefone</th>
              <th scope="col" className="px-6 py-3"></th>
            </tr>
          </thead>
          {
            contact.map((el) => {
              return (
                <tbody key={el.id}>
                  <tr className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                    <td className="px-6 py-4 font-medium text-gray-900 dark:text-white whitespace-nowrap">{el.name}</td>
                    <td className="px-6 py-4">{el.lastName}</td>
                    <td className="px-6 py-4">{el.email}</td>
                    <td className="px-6 py-4">{el.cpf}</td>
                    <td className="px-6 py-4">{el.phone}</td>
                    <td className="space-x-4 cursor-pointer">
                      <Link to={"/editar/" + el.id} className="text-yellow-500">EDITAR</Link>
                      <button type="button" onClick={(e) => handlerDelete(e, el.id)} className="text-red-500">EXCLUIR</button>
                    </td>

                  </tr>
                </tbody>
              )
            })
          }
        </table>
      </div>


      <PostModal showModal={showModal} setShowModal={setShowModal} />



    </div>
  )
}

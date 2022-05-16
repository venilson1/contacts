import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router'
import api from '../services/api';

export default function Details() {

  const { id } = useParams();
  const [contact, setContact] = useState([]);

  const navigate = useNavigate();

  useEffect(() => {
    api
      .get("/" + id)
      .then((response) => setContact(response.data))
      .catch((err) => {
        console.error("ops! ocorreu um erro " + err);
      });
  }, [id]);

  const handlerInputChange = (e) => {
    const { name, value } = e.target;
    setContact({ ...contact, [name]: value });
  };


  const handlerUpdateContact = () => {
    api
      .put("/" + id, contact)
      .catch((err) => {
        console.error("ops! ocorreu um erro " + err);
      })

    navigate('/');

  };


  return (
    <>
      <form className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4"

      >
        <div className="flex flex-wrap space-x-6">
          <div className="mb-4">
            <label
              className="cursor-pointer block text-gray-700 text-sm font-bold mb-2"
              htmlFor="name">
              Nome
            </label>
            <input
              className="shadow appearance-none border rounded w-full py-2 px-3 
                      text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              name="name"
              id="name"
              type="text"
              placeholder="Nome"
              value={contact?.name || ""}
              onChange={handlerInputChange}
              required
            />
          </div>
          <div className="mb-6">
            <label className="cursor-pointer block text-gray-700 text-sm font-bold mb-2" htmlFor="lastName">
              Sobrenome
            </label>
            <input className="shadow appearance-none border rounded w-full py-2 
          px-3 text-gray-700 mb-3 leading-tight focus:outline-none 
          focus:shadow-outline"
              name="lastName" id="lastName"
              type="text"
              placeholder="Sobrenome"
              value={contact?.lastName || ""}
              onChange={handlerInputChange}
            />
          </div>
        </div>
        <div className="flex flex-wrap space-x-6">
          <div className="mb-4">
            <label className="cursor-pointer block text-gray-700 
                      text-sm font-bold mb-2"
              htmlFor="email">
              Email
            </label>
            <input className="shadow appearance-none border rounded w-full 
                      py-2 px-3 text-gray-700 leading-tight focus:outline-none 
                      focus:shadow-outline"
              name="email"
              id="email"
              type="email"
              placeholder="exemplo@exemplo.com"
              value={contact?.email || ""}
              onChange={handlerInputChange}
              required
            />
          </div>
          <div className="mb-6">
            <label className="cursor-pointer block text-gray-700 
                      text-sm font-bold mb-2" htmlFor="cpf">
              CPF
            </label>
            <input className="shadow appearance-none border rounded 
                      w-full py-2 px-3 text-gray-700 mb-3 leading-tight 
                      focus:outline-none focus:shadow-outline"
              name="cpf"
              id="cpf"
              type="text"
              placeholder="000.000.000-00"
              value={contact?.cpf || ""}
              onChange={handlerInputChange}
              required
            />
          </div>
        </div>
        <div className="flex flex-wrap space-x-6">
          <div className="mb-4">
            <label className="cursor-pointer block text-gray-700 
                      text-sm font-bold mb-2" htmlFor="phone">
              Telefone
            </label>
            <input className="shadow appearance-none border rounded 
                      w-full py-2 px-3 text-gray-700 leading-tight
                       focus:outline-none focus:shadow-outline"
              name="phone"
              id="phone"
              type="phone"
              placeholder="011900000000"
              value={contact?.phone || ""}
              onChange={handlerInputChange}
              required
            />
          </div>
        </div>

      </form>
      <div className=" flex items-center justify-center p-6 border-t 
                    border-solid border-slate-200 rounded-b">
        <button
          className="bg-emerald-500 text-gray-100 active:bg-emerald-600 
                        font-bold uppercase text-sm px-6 py-3 rounded shadow hover:shadow-lg 
                        outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all 
                        duration-150"
          type="button"
          onClick={() => handlerUpdateContact()}
        >
          Salvar
        </button>
        <button
          className="text-red-500 background-transparent font-bold uppercase px-6 py-2 text-sm outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
          type="button"
        >
          Fechar
        </button>
      </div>
    </>
  )
}

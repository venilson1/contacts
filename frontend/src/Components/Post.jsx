import React, { useState } from 'react'
import api from '../services/api';

export default function PostModal({ showModal, setShowModal }) {

  const initialForm = {
    name: "",
    lastName: "",
    email: "",
    cpf: "",
    phone: "",
  };

  const [formValues, setformValues] = useState(initialForm);

  const handlerInputChange = (e) => {
    const { name, value } = e.target;
    setformValues({ ...formValues, [name]: value });
  };

  const handlerNewContact = () => {
    api
      .post("/", formValues)
      .catch((err) => {
        console.error("ops! ocorreu um erro " + err);
      })

    setShowModal(false)
  };

  return (
    <>
      {showModal ? (
        <>
          <div
            className="justify-center items-center flex overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none"
          >
            <div className="relative w-auto my-6 mx-auto max-w-3xl">
              {/*content*/}
              <div className="border-0 rounded-lg shadow-lg relative flex flex-col w-full bg-white outline-none focus:outline-none">
                {/*header*/}
                <h3 className="text-3xl font-semibold text-center w-full py-4">
                  Adcionar Contato
                </h3>
                {/*body*/}
                <form className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
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
                        value={formValues.name || ""}
                        onChange={handlerInputChange}
                        required
                      />
                    </div>
                    <div className="mb-6">
                      <label className="cursor-pointer block text-gray-700 text-sm font-bold mb-2" htmlFor="lastName">
                        Sobrenome
                      </label>
                      <input className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline" name="lastName" id="lastName" type="text" placeholder="Sobrenome" onChange={handlerInputChange} value={formValues.lastName || ""} />
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
                        value={formValues.email || ""}
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
                        value={formValues.cpf.replace(/[^0-9]/g, "").replace(/^([\d]{3})([\d]{3})?([\d]{3})?([\d]{2})?/, "$1.$2.$3-$4") || ""}
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
                        value={formValues.phone || ""}
                        onChange={handlerInputChange}
                        required
                      />
                    </div>
                  </div>

                </form>
                {/*footer*/}
                <div className=" flex items-center justify-center p-6 border-t 
                border-solid border-slate-200 rounded-b">
                  <button
                    className="bg-emerald-500 text-gray-100 active:bg-emerald-600 
                    font-bold uppercase text-sm px-6 py-3 rounded shadow hover:shadow-lg 
                    outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all 
                    duration-150"
                    type="button"
                    onClick={() => handlerNewContact()}
                  >
                    Salvar
                  </button>
                  <button
                    className="text-red-500 background-transparent font-bold uppercase px-6 py-2 text-sm outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                    type="button"
                    onClick={() => setShowModal(false)}
                  >
                    Fechar
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div className="opacity-25 fixed inset-0 z-40 bg-black"></div>
        </>
      ) : null}
    </>
  )
}

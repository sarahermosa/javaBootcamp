import React, {useState} from 'react';
import axios from 'axios';
import './RegistrationForm.css';
import {API_BASE_URL, ACCESS_TOKEN_NAME} from '../../constants/apiConstants';
import { withRouter } from "react-router-dom";

function RegistrationForm(props) {
    const [state , setState] = useState({
        first_name : "",
        last_name : "",
        nro_documento : "",
        email : "",
        password : "",
        fecha_nacimiento: "",
        nro_telefono: "",
        successMessage: null
    })
    const handleChange = (e) => {
        const {id , value} = e.target   
        setState(prevState => ({
            ...prevState,
            [id] : value
        }))
    }
    const sendDetailsToServer = () => {
        if(state.email.length && state.password.length) {
            props.showError(null);
            const payload={
                "first_name":state.first_name,
                "last_name":state.last_name,
                "nro_documento":state.nro_documento,
                "email":state.email,
                "password":state.password,
                "fecha_nacimiento":state.fecha_nacimiento,
                "nro_telefono":state.nro_telefono
            }
            console.log(payload)
            axios.post(API_BASE_URL+'/registro/', payload)
                .then(function (response) {
                    if(response.status === 201){
                        setState(prevState => ({
                            ...prevState,
                            'successMessage' : 'Registration successful. Redirecting to home page..'
                        }))
                        console.log(response)
                        localStorage.setItem(ACCESS_TOKEN_NAME,response.data.token);
                        redirectToHome();
                        props.showError(null)
                    } else{
                        props.showError("Some error ocurred");
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });    
        } else {
            props.showError('Please enter valid username and password')    
        }
        
    }
    const redirectToHome = () => {
        props.updateTitle('Home')
        props.history.push('/home');
    }
    const redirectToLogin = () => {
        props.updateTitle('Login')
        props.history.push('/login'); 
    }
    const handleSubmitClick = (e) => {
        e.preventDefault();
        sendDetailsToServer();
        // if(state.password === state.confirmPassword) {
        //     sendDetailsToServer()    
        // } else {
        //     props.showError('Passwords do not match');
        // }
    }
    return(
        <div className="card col-12 col-lg-4 login-card mt-2 hv-center">
            <form>
                <div className="form-group text-left">
                    <div className="form-group text-left">
                        <label htmlFor="exampleInputPassword1">Nombre</label>
                        <input type="text" 
                            className="form-control" 
                            id="first_name" 
                            placeholder="Add Name"
                            value={state.first_name}
                            onChange={handleChange} 
                        />
                    </div>
                    <div className="form-group text-left">
                        <label htmlFor="exampleInputPassword1">Apellido</label>
                        <input type="text" 
                            className="form-control" 
                            id="last_name" 
                            placeholder="Add Last Name"
                            value={state.last_name}
                            onChange={handleChange} 
                        />
                    </div>
                    <div className="form-group text-left">
                        <label htmlFor="exampleInputPassword1">Nro. Documento</label>
                        <input type="text" 
                            className="form-control" 
                            id="nro_documento" 
                            placeholder="Add Nro. Documento"
                            value={state.nro_documento}
                            onChange={handleChange} 
                        />
                    </div>
                    <label htmlFor="exampleInputEmail1">Email</label>
                    <input type="email" 
                        className="form-control" 
                        id="email" 
                        aria-describedby="emailHelp" 
                        placeholder="Enter email" 
                        value={state.email}
                        onChange={handleChange}
                    />
                </div>
                <div className="form-group text-left">
                    <label htmlFor="exampleInputPassword1">Contraseña</label>
                    <input type="password" 
                        className="form-control" 
                        id="password" 
                        placeholder="Password"
                        value={state.password}
                        onChange={handleChange} 
                    />
                </div>
                <div className="form-group text-left">
                    <label htmlFor="exampleInputEmail1">Fecha Nacimiento</label>
                    <input type="text" 
                        className="form-control" 
                        id="fecha_nacimiento" 
                        placeholder="Fecha Nacimiento"
                        value={state.fecha_nacimiento}
                        onChange={handleChange} 
                    />
                </div>
                <div className="form-group text-left">
                    <label htmlFor="exampleInputEmail1">Nro. Telefono</label>
                    <input type="text" 
                        className="form-control" 
                        id="nro_telefono" 
                        placeholder="Nro. Telefono"
                        value={state.nro_telefono}
                        onChange={handleChange} 
                    />
                </div>
                <button 
                    type="submit" 
                    className="btn btn-primary"
                    onClick={handleSubmitClick}
                >
                    Registrarse
                </button>

                <div className="mt-2">
                    <span>Already have an account? </span>
                    <span className="loginText" onClick={() => redirectToLogin()}>Login here</span> 
                </div>

            </form>
            <div className="alert alert-success mt-2" style={{display: state.successMessage ? 'block' : 'none' }} role="alert">
                {state.successMessage}
            </div>

            
        </div>
    )
}

export default withRouter(RegistrationForm);
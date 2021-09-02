import React, { useState } from 'react';
import PageHeader from '../../components/PageHeader';
import Input from '../../components/Input';
import './styles.css'

function Login(){

    //Valor inicial do input será zero
    const [name, setName] = useState('');
    const [password, setPassword] = useState('');
    
    return(
        <div id="page-login-form" className="container">
        <PageHeader 
        title="Bem vindxs"         
        />

        <main>            
            <form>
            <fieldset>
                <legend>Login</legend>
                <Input 
                    name="name" 
                    label="Usuário" 
                    value={name} 
                    // "e" seria um evento feito no input da qual vou pegar o valor desse evento
                    // e setar na variavel name para mudar o estado
                    onChange={(e) => {setName(e.target.value)}}/>
                <Input
                    name="password"
                    label="Senha" 
                    value={password}
                    onChange={(e) => {setPassword(e.target.value)}}
                />
               
            </fieldset>
            <footer>                
                <button type="button">
                    Login
                </button>
            </footer>
            </form>
        </main>

    </div>
    );
}

export default Login;
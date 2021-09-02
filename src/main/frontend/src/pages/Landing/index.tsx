import React, { useState, useEffect } from 'react';
import './styles.css'
import {Link} from 'react-router-dom';

/* As imagens passam a ser uma variável javascript que dentro dela tem esse path e para ser usada
dentro do HTML tem que estar entre chaves para ele entender que é uma variável.
*/
import landingImg from '../../assets/images/ATA.png';
import studyIcon from '../../assets/images/icons/study.svg';
import givenClassesIcon from '../../assets/images/icons/give-classes.svg';
//import api from '../../service/api';


function Landing(){
    // Vai iniciar como zero
    const [totalConnections, setTotalConnections] = useState(0);

    // O Array fica vazio porque é sempre que entrar na página que dispara a função. 
    // Poderia ser uma variável que quando mudasse disparasse a função.
//    useEffect(() => {
//        // O then é quando fica aguardando a resposta do backend
//        api.get('connections').then((response: { data: { total: any; }; }) => {
//            // Olha o console para saber certinho qual caminho pegar da response
//            //console.log(response);
//            const {total} = response.data;
//            setTotalConnections(total);
//        })
//    }, []);

    return (
        <div id="page-landing">
            <div id="page-landing-content" className="container">
                <div className="logo-container">
                    <h2>Site desenvolvido para estudar  habilidades de Spring, Java e React.</h2>
                </div>
                <img src={landingImg} alt="Imagem" className="hero-image"/>
                <div className="buttons-container">
                    <Link to="/info" className="info">
                        <img src={studyIcon} alt="Saiba Mais"/>
                        Saiba Mais
                    </Link>
                    <Link to="/login" className="login-button">
                        <img src={givenClassesIcon} alt="Login"/>
                        Login
                    </Link>                    
                </div>
            </div>
        </div>
    );
}


/*Poder exportar para a App*/
export default Landing;
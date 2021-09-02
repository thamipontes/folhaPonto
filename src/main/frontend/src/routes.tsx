import React from 'react';
import {BrowserRouter, Route} from 'react-router-dom';
import Landing from './pages/Landing';
import Login from './pages/Login';


function Routes(){
    return(
        <BrowserRouter>
            {/* O exact é para mostrar a landing quando for apenas "/", pois os outros 
            também tem a barra, e se não colocar o exact vai mostrar a landing mais o conteúdo
            da outra componente */}
            <Route path="/" exact component={Landing}/>
            <Route path="/login" component={Login}/>


        </BrowserRouter>
    );
}

export default Routes;
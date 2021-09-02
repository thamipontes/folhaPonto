import React, {InputHTMLAttributes} from 'react';
import './styles.css';

interface InputProps extends InputHTMLAttributes<HTMLInputElement> {
    name: string;
    label: string;
}
// O ...rest é pra simplificar e dizer que depois podemos pegar qualquer outra propriedade restante
// que o input tiver. PS: o nome não precisa ser rest, pode ser qualquer outro nome
const Input: React.FC<InputProps> = ({label, name, ...rest}) => {
    return(
         <div className="input-block">
        <label htmlFor={name}> {label} </label>
            <input type="text" id={name} {...rest}/>
        </div>


    );

}

export default Input;
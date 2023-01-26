import React, {useState} from 'react'
import AmazonLogo from "../../Amazon_Logo.png"
import { Link } from 'react-router-dom'


import "./Login.css"

const Login = () => {
  const [email, setEmail] = useState("")
  return (
    <div className='login'>
        <Link to={"/"}>
            <img src={AmazonLogo} className="login-logo" alt="logo" />
        </Link>
        <div className="login-container">
            <h1>Sign In</h1>
            <form action="">
                <h5>Email:</h5>
                <input type="email" />
            </form>
        </div>
    </div>
  )
}

export default Login
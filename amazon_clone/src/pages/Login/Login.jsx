import React, {useState} from 'react'
import AmazonLogo from "../../Amazon_Logo.png"
import { Link } from 'react-router-dom'


import "./Login.css"

const Login = () => {
  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")

  const signIn = (e) => {
    e.preventdefault()

  }
  return (
    <div className='login'>
        <Link to={"/"}>
            <img src={AmazonLogo} className="login-logo" alt="logo" />
        </Link>
        <div className="login-container">
            <h1>Sign In</h1>
            <form action="">
                <h5>Email:</h5>
                <input type="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
                <h5>Password:</h5>
                <input type="password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
                <button type='submit' onClick={signIn} className="login-signIn">Sign In</button>
            </form>
            <p>By continuing, you agree to Amazon's Terms and Conditions of use and Privacy Notice</p>
        </div>
        <p>New to Amazon?</p>
        <Link to={"/register"}>
          <button className="login-register">Create Your Account</button>
        </Link>
    </div>
  )
}

export default Login
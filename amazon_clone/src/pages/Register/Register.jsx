import React, {useState} from 'react'
import { Link } from 'react-router-dom'
import AmazonLogo from "../../Amazon_Logo.png"

import "./Register.css"

const Register = () => {
  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")

  const register = (e) => {
    e.preventDefault()
  }

  return (
    <div className='register'>
      <Link to={"/"}>
        <img src={AmazonLogo} className='register-logo' alt="logo"/>
      </Link>
      <div className="register-container">
        <h1>Create Account</h1>
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
          <button type='submit' onClick={register} className="continue">Continue</button>

          <div className="detail">
            <p>Already have an Account? </p>
            <Link to={"/login"} className="signin-link">
              <p>Sign In</p>
            </Link>
          </div>
        </form>
      </div>
    </div>
  )
}

export default Register
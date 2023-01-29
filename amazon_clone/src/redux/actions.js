import * as types from "./actionTypes"
import { auth } from "../utils/firebase"

const registerStart = () => ({
    type: types.REGISTER_START,
})

const registerSuccess = (user) => ({
    type: types.REGISTER_SUCCESS,
    payload:user
})

const registerFailure = (error) => ({
    type: types.REGISTER_FAILURE,
    payload:error,
})


export const registerInitiate = (email, password) => {
    return function(dispatch){
        dispatch(registerStart());
        auth.createUserWithEmailAndPassword(email, password)
        .then(({user}) => {
            dispatch(registerSuccess(user));
        })
        .catch((error) => dispatch(registerFailure(error.message)));
    };
}
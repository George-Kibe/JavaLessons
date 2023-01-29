import * as types from "./actionTypes"

const initialSate = {
    loading: false,
    basket:[],
    user:null,
    error:null,
};

const basketReducer = (state = initialSate, action) => {
    switch (action.type){
        case types.REGISTER_START:
            return {
                ...state,
                loading:true,
            }
        case types.REGISTER_SUCCESS:
            return {
                ...state,
                loading:false,
                user:action.payload,
            }
        case types.REGISTER_FAILURE:
            return {
                ...state,
                loading:false,
                error:action.payload,
            }
        default:
            return state;
    }
}

export default basketReducer;
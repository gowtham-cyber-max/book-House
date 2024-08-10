const initialState = {
    user: null,
    userType: 'guest',
    error: null,
    wishlist: [],
}

const userReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'SET_USER':
            return {
                ...state,
                user: action.payload,
                wishlist: []
            }
        case 'SET_USER_TYPE':
            return {
                ...state,
                userType: action.payload
            }
        case 'SET_ERROR':
            return {
                ...state,
                error: action.payload
            }
        case "SET_WISHLIST":
            return {
                ...state,
                wishlist: action.payload
            }
        default:
            return state
    }
}

export default userReducer;
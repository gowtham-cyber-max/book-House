import userServices from "../services/userServices";
const serv = userServices;

export const signUp = (data) => async (dispatch, getState) => {
    try {
        const res = await serv.signUp(data);
        if (res.status !== 201) {
            console.log("Error adding user");
        } else {
            dispatch({ type: "SET_USER", payload: res.data })
        }
    } catch (error) {
        console.log(error)
    }
}

export const signIn = (user, password) => async (dispatch, getState) => {
    try {
        const res = await serv.signIn(user, password);
        if (res.data !== "success") {
            dispatch({ type: "SET_USER", payload: res.data })
            if (res.data.user == "ranga") { // change to your user name
                console.log("admin logged in");
                dispatch({ type: "SET_USER_TYPE", payload: "admin" })
            } else {
                console.log(res.data);
            }
        }
    } catch (error) {
        dispatch({ type: "SET_ERROR", payload: error.response.data })
    }
}

export const addToWish = (bid) => async (dispatch, getState) => {
    const uid = getState().user.user.id;
    try {
        const res = await serv.wish(uid, bid);
    } catch (error) {
        console.log(error)
    }
    dispatch({ type: "SET_USER", payload: res.data });
}

export const getWishlist = () => async (dispatch, getState) => {
    const IDs = getState().user.user.wishlist;
    try {
        const res = await serv.getWishlistBooks(IDs);
        dispatch({ type: "SET_WISHLIST", payload: res.data });
    } catch (error) {
        console.log(error)
    }
}

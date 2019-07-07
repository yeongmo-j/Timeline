
export const fetching = (url, requestMethod, body) => {
    /*
    let token = localStorage.getItem('token')
    if (token == null){
        token = 'Empty'
    }
    */
    fetch(url, {
        method : requestMethod,
        headers : {
            'token' : 'token',
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(body)
    })
    .then(response => {
        'response 판별 해준 후 오류 처리 해 주고 보내주기'
        console.log(response)
        if (response.status === 200){
            //'이때만 성공'
            return response
        } else {

        }
    })
}


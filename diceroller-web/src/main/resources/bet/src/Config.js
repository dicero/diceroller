
export function IsLogin(Pubsub, code) {
    if (code === 102) {
        console.log(PubSub)
        PubSub.publish( 'IsLoign', true );
    } else {
        console.log('是否登录',code)
    } 
}


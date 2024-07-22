package wateenselfcare

class UrlMappings {

    static mappings = {
        "/"(controller: "auth", action: "index")
        "/signIn"(controller: "auth", action: "signIn")
        "500"(view:'/error')
        "404"(view:'/notFound')
        }




}

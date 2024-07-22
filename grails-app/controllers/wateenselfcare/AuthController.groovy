package wateenselfcare

class AuthController {

    def index() {
        render(view: 'signIn')
    }

    def signIn() {
        String username = params.username
        String password = params.password
        String userIP = request.getRemoteAddr()

        if (username == null || password == null) {
            render(view: 'signIn')

        }
        if (username && password && userIP) {
            if (!username.endsWith("@wateen.net")) {
                username += "@wateen.net"
            }
            def hexUserName = username.bytes.encodeHex()
            println("hex name ${hexUserName}")
            def bashCommand = "echo \"Framed-IP-Address=${userIP},Huawei-Command-Mode='0x01${hexUserName}',Huawei-User-Password='${password}'\" |radclient -x 58.27.191.25:3799 coa brassecret";
            println(bashCommand)
            try {
                def output = executeCommandAndCaptureOutput(bashCommand)
                println("output ${output}")
                render(view: '../Action')
            } catch (Exception e) {
                println("Error ${e}")
                redirect(action: "index")
            }
        }
    }

    def executeCommandAndCaptureOutput(String command) {
        String osName = System.getProperty("os.name").toLowerCase();
        def processBuilder
        if (osName.contains("windows")) {
            processBuilder = new ProcessBuilder("cmd.exe", "/c", command)
        } else {
            processBuilder = new ProcessBuilder("/bin/bash", "-c", command)
        }
        processBuilder.redirectErrorStream(true)
        def process = processBuilder.start()
        def output = process.getInputStream().getText();
        process.waitFor()
        return output;

    }

    def signOut() {

    }
}

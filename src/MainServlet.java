import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/31 0031.
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
    int tvSwitchItem = 0;
    int airSwitchItem = 0;
    int airStyleItem = 0;
    int airWindItem = 0;
    int airWindDirectionItem = 0;
    int fanShakeHeadItem = 0;
    int fanSwitchItem = 0;
    int lightSwitchItem = 0;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // http://localhost:8080/main?action=b&act2=zzzz
        String action=request.getParameter("action");
        String action2=request.getParameter("action2");
        switch (action){
            case "tvSwitch":
                tvSwitch();
                break;
            case "tvInputButton":
                tvInputButton();
                break;
            case "tvHomeButton":
                tvHomeButton();
                break;
            case "tvMenuButton":
                tvMenuButton();
                break;
            case "tvBackButton":
                tvBackButton();
                break;
            case "tvSilentButton":
                tvSilentButton();
                break;
            case "tvChUP":
                tvChUP();
                break;
            case "tvVolUp":
                tvVolUp();
                break;
            case "tvChDown":
                tvChDown();
                break;
            case "tvVolDown":
                tvVolDown();
                break;
            case "tvOkButton":
                tvOkButton();
                break;
            case "airSwitch":
                airSwitch();
                break;
            case "airSleepButton":
                airSleepButton();
                break;
            case "airTemperUp":
                airTemperUp();
                break;
            case "airTemperDown":
                airTemperDown();
                break;
            case "airStyle":
                airStyle();
                break;
            case "airWindScale":
                airWindScale();
                break;
            case "airWindDirection":
                airWindDirection();
                break;
            case "fanNormalWindButton":
                fanNormalWindButton();
                break;
            case "fanNatureWindButton":
                fanNatureWindButton();
                break;
            case "fanSilentWindButton":
                fanSilentWindButton();
                break;
            case "fanSleepWindButton":
                fanSleepWindButton();
                break;
            case "fanSwitch":
                fanSwitch();
                break;
            case "fanShakeHead":
                fanShakeHead();
                break;
            case "fanWindLevel":
                System.out.println("服务器接收控制命令：风扇 风速："+action2+"档");
                break;
            case "fanClockButton":
                System.out.println("服务器接收控制命令：风扇 定时时间："+action2);
                break;
            case "airClockButton":
                System.out.println("服务器接收控制命令：空调 定时时间："+action2);
                break;
            case "LightBrightness":
                System.out.println("服务器接收控制命令：灯光 亮度："+action2+"%");
                break;
            case "lightColor":
                System.out.println("服务器接收控制命令：灯光 光颜色RGB："+action2);
                break;
            case "lightSwitch":
                lightSwitch();
                break;
            case "airRoomTemper":
                System.out.println("服务器返回当前室温的JSON数据包给客户端APP");
                //返回一个json格式的数据包,20-27之间的一个随机数来模拟温度
                int temp = 20+(int)(Math.random()*7);
                String item = "{\"temp\":\""+temp+"\"}";
                response.getOutputStream().print(item);
                break;
            case "admin":
                System.out.println("服务器返回设备列表的JSON数据包给客户端APP");
                //返回一个json格式的数据包,模拟存储在服务器的设备列表
                //不支持中文
                String equipList = "[{\"id\":\"1\",\"name\":\"ketingTV\"},{\"id\":\"2\",\"name\":\"ketingFAN\"}," +
                        "{\"id\":\"3\",\"name\":\"ketingLIGHT\"},{\"id\":\"4\",\"name\":\"ketingAIR\"}," +
                        "{\"id\":\"5\",\"name\":\"chufangTV\"},{\"id\":\"6\",\"name\":\"chufangFAN\"}," +
                        "{\"id\":\"7\",\"name\":\"woshiTV\"}]";
                response.getOutputStream().print(equipList);
                break;
            default:
                break;
        }
    }

    private void lightSwitch() {
        if (lightSwitchItem == 0){
            System.out.println("服务器接收控制命令：灯光 开");
            lightSwitchItem = 1;
        }else{
            System.out.println("服务器接收控制命令：灯光 关");
            lightSwitchItem = 0;
        }
    }

    private void fanShakeHead() {
        if (fanShakeHeadItem == 0){
            System.out.println("服务器接收控制命令：风扇 摇头开");
            fanShakeHeadItem = 1;
        }else{
            System.out.println("服务器接收控制命令：风扇 摇头关");
            fanShakeHeadItem = 0;
        }
    }

    private void fanSwitch() {
        if (fanSwitchItem == 0){
            System.out.println("服务器接收控制命令：风扇 开");
            fanSwitchItem = 1;
        }else{
            System.out.println("服务器接收控制命令：风扇 关");
            fanSwitchItem = 0;
        }
    }

    private void fanSleepWindButton() {
        System.out.println("服务器接收控制命令：风扇 睡眠风");
    }

    private void fanSilentWindButton() {
        System.out.println("服务器接收控制命令：风扇 静音风");
    }

    private void fanNatureWindButton() {
        System.out.println("服务器接收控制命令：风扇 自然风");
    }

    private void fanNormalWindButton() {
        System.out.println("服务器接收控制命令：风扇 正常风");
    }

    private void airWindDirection() {
        if (airWindDirectionItem == 0){
            airWindDirectionItem = 1;
            System.out.println("服务器接收控制命令：空调 上下扫风");
        } else if (airWindDirectionItem == 1){
            airWindDirectionItem = 2;
            System.out.println("服务器接收控制命令：空调 左右扫风");
        }else if (airWindDirectionItem == 2) {
            airWindDirectionItem = 0;
            System.out.println("服务器接收控制命令：空调 停止扫风");
        }
    }

    private void airWindScale() {
        if (airWindItem == 0){
            airWindItem = 1;
            System.out.println("服务器接收控制命令：空调 风速-微风");
        } else if (airWindItem == 1){
            airWindItem = 2;
            System.out.println("服务器接收控制命令：空调 风速-弱风");
        }else if (airWindItem == 2) {
            airWindItem = 3;
            System.out.println("服务器接收控制命令：空调 风速-强风");
        }else if (airWindItem == 3){
            airWindItem = 0;
            System.out.println("服务器接收控制命令：空调 风速-自动");
        }
    }

    private void airStyle() {
        if (airStyleItem==0){
            airStyleItem = 1;
            System.out.println("服务器接收控制命令：空调 制热模式");
        } else if(airStyleItem == 1) {
            airStyleItem = 2;
            System.out.println("服务器接收控制命令：空调 制冷模式");
        }else if(airStyleItem == 2) {
            airStyleItem = 3;
            System.out.println("服务器接收控制命令：空调 除湿模式");
        }else if(airStyleItem == 3) {
            airStyleItem = 0;
            System.out.println("服务器接收控制命令：空调 送风模式");
        }
    }

    private void airTemperDown() {
        System.out.println("服务器接收控制命令：空调 温度-");
    }

    private void airTemperUp() {
        System.out.println("服务器接收控制命令：空调 温度+");
    }

    private void airSleepButton() {
        System.out.println("服务器接收控制命令：空调 睡眠");
    }

    private void airSwitch() {
        if (airSwitchItem == 0){
            System.out.println("服务器接收控制命令：空调 开");
            airSwitchItem = 1;
        }else{
            System.out.println("服务器接收控制命令：空调 关");
            airSwitchItem = 0;
        }
    }

    private void tvOkButton() {
        System.out.println("服务器接收控制命令：电视 确定");
    }

    private void tvVolDown() {
        System.out.println("服务器接收控制命令：电视 音量-");
    }

    private void tvChDown() {
        System.out.println("服务器接收控制命令：电视 频道-");
    }

    private void tvVolUp() {
        System.out.println("服务器接收控制命令：电视 音量+");
    }

    private void tvChUP() {
        System.out.println("服务器接收控制命令：电视 频道+");
    }

    private void tvSilentButton() {
        System.out.println("服务器接收控制命令：电视 静音");
    }

    private void tvBackButton() {
        System.out.println("服务器接收控制命令：电视 返回");
    }

    private void tvMenuButton() {
        System.out.println("服务器接收控制命令：电视 菜单");
    }

    private void tvHomeButton() {
        System.out.println("服务器接收控制命令：电视 主页");
    }

    private void tvInputButton() {
        System.out.println("服务器接收控制命令：电视 输入源");
    }

    private void tvSwitch() {
        if (tvSwitchItem == 0){
            System.out.println("服务器接收控制命令：电视 开");
            tvSwitchItem = 1;
        }else{
            System.out.println("服务器接收控制命令：电视 关");
            tvSwitchItem = 0;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

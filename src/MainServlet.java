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
                System.out.println("���������տ���������� ���٣�"+action2+"��");
                break;
            case "fanClockButton":
                System.out.println("���������տ���������� ��ʱʱ�䣺"+action2);
                break;
            case "airClockButton":
                System.out.println("���������տ�������յ� ��ʱʱ�䣺"+action2);
                break;
            case "LightBrightness":
                System.out.println("���������տ�������ƹ� ���ȣ�"+action2+"%");
                break;
            case "lightColor":
                System.out.println("���������տ�������ƹ� ����ɫRGB��"+action2);
                break;
            case "lightSwitch":
                lightSwitch();
                break;
            case "airRoomTemper":
                System.out.println("���������ص�ǰ���µ�JSON���ݰ����ͻ���APP");
                //����һ��json��ʽ�����ݰ�,20-27֮���һ���������ģ���¶�
                int temp = 20+(int)(Math.random()*7);
                String item = "{\"temp\":\""+temp+"\"}";
                response.getOutputStream().print(item);
                break;
            case "admin":
                System.out.println("�����������豸�б��JSON���ݰ����ͻ���APP");
                //����һ��json��ʽ�����ݰ�,ģ��洢�ڷ��������豸�б�
                //��֧������
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
            System.out.println("���������տ�������ƹ� ��");
            lightSwitchItem = 1;
        }else{
            System.out.println("���������տ�������ƹ� ��");
            lightSwitchItem = 0;
        }
    }

    private void fanShakeHead() {
        if (fanShakeHeadItem == 0){
            System.out.println("���������տ���������� ҡͷ��");
            fanShakeHeadItem = 1;
        }else{
            System.out.println("���������տ���������� ҡͷ��");
            fanShakeHeadItem = 0;
        }
    }

    private void fanSwitch() {
        if (fanSwitchItem == 0){
            System.out.println("���������տ���������� ��");
            fanSwitchItem = 1;
        }else{
            System.out.println("���������տ���������� ��");
            fanSwitchItem = 0;
        }
    }

    private void fanSleepWindButton() {
        System.out.println("���������տ���������� ˯�߷�");
    }

    private void fanSilentWindButton() {
        System.out.println("���������տ���������� ������");
    }

    private void fanNatureWindButton() {
        System.out.println("���������տ���������� ��Ȼ��");
    }

    private void fanNormalWindButton() {
        System.out.println("���������տ���������� ������");
    }

    private void airWindDirection() {
        if (airWindDirectionItem == 0){
            airWindDirectionItem = 1;
            System.out.println("���������տ�������յ� ����ɨ��");
        } else if (airWindDirectionItem == 1){
            airWindDirectionItem = 2;
            System.out.println("���������տ�������յ� ����ɨ��");
        }else if (airWindDirectionItem == 2) {
            airWindDirectionItem = 0;
            System.out.println("���������տ�������յ� ֹͣɨ��");
        }
    }

    private void airWindScale() {
        if (airWindItem == 0){
            airWindItem = 1;
            System.out.println("���������տ�������յ� ����-΢��");
        } else if (airWindItem == 1){
            airWindItem = 2;
            System.out.println("���������տ�������յ� ����-����");
        }else if (airWindItem == 2) {
            airWindItem = 3;
            System.out.println("���������տ�������յ� ����-ǿ��");
        }else if (airWindItem == 3){
            airWindItem = 0;
            System.out.println("���������տ�������յ� ����-�Զ�");
        }
    }

    private void airStyle() {
        if (airStyleItem==0){
            airStyleItem = 1;
            System.out.println("���������տ�������յ� ����ģʽ");
        } else if(airStyleItem == 1) {
            airStyleItem = 2;
            System.out.println("���������տ�������յ� ����ģʽ");
        }else if(airStyleItem == 2) {
            airStyleItem = 3;
            System.out.println("���������տ�������յ� ��ʪģʽ");
        }else if(airStyleItem == 3) {
            airStyleItem = 0;
            System.out.println("���������տ�������յ� �ͷ�ģʽ");
        }
    }

    private void airTemperDown() {
        System.out.println("���������տ�������յ� �¶�-");
    }

    private void airTemperUp() {
        System.out.println("���������տ�������յ� �¶�+");
    }

    private void airSleepButton() {
        System.out.println("���������տ�������յ� ˯��");
    }

    private void airSwitch() {
        if (airSwitchItem == 0){
            System.out.println("���������տ�������յ� ��");
            airSwitchItem = 1;
        }else{
            System.out.println("���������տ�������յ� ��");
            airSwitchItem = 0;
        }
    }

    private void tvOkButton() {
        System.out.println("���������տ���������� ȷ��");
    }

    private void tvVolDown() {
        System.out.println("���������տ���������� ����-");
    }

    private void tvChDown() {
        System.out.println("���������տ���������� Ƶ��-");
    }

    private void tvVolUp() {
        System.out.println("���������տ���������� ����+");
    }

    private void tvChUP() {
        System.out.println("���������տ���������� Ƶ��+");
    }

    private void tvSilentButton() {
        System.out.println("���������տ���������� ����");
    }

    private void tvBackButton() {
        System.out.println("���������տ���������� ����");
    }

    private void tvMenuButton() {
        System.out.println("���������տ���������� �˵�");
    }

    private void tvHomeButton() {
        System.out.println("���������տ���������� ��ҳ");
    }

    private void tvInputButton() {
        System.out.println("���������տ���������� ����Դ");
    }

    private void tvSwitch() {
        if (tvSwitchItem == 0){
            System.out.println("���������տ���������� ��");
            tvSwitchItem = 1;
        }else{
            System.out.println("���������տ���������� ��");
            tvSwitchItem = 0;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

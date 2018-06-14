package mmgg;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;
import org.apache.zookeeper.CreateMode;

import java.util.Date;
import java.util.List;

/**
 * @Auther: wangxinjie
 * @Date: 2018/6/12 14:12
 * @Description:
 */
public class ZkClinet {

    //zk链接地址
    static final String CONNECT_ADDR = "39.108.184.140:2181";
    //sesion超时时间
    static final int sessionTime = 10000;

    public static void main(String[] args) {
        try {
            ZkClient zkc = new ZkClient(new ZkConnection(CONNECT_ADDR), sessionTime);
            //1.add
           // zkc.create("/zkClinet","test",CreateMode.PERSISTENT);

            //2. 设置path和data 并且读取子节点和每个节点的内容
           /* zkc.createPersistent("/super", "1234");
            zkc.createPersistent("/super/c1", "c1内容");
            zkc.createPersistent("/super/c2", "c2内容");
            List<String> list = zkc.getChildren("/super");
            for(String p : list){
                System.out.println(p);
                String rp = "/super/" + p;
                String data = zkc.readData(rp);
                System.out.println("节点为：" + rp + "，内容为: " + data);
            }*/

            //3.update
            /*zkc.writeData("/super/c1","新内容");
            System.out.println(zkc.readData("/super/c1".toString()));
            System.out.println(zkc.exists("/super/c1"));*/

            //递归删除
            zkc.deleteRecursive("/super");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

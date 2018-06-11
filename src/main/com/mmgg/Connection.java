package mmgg;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @Auther: wangxinjie
 * @Date: 2018/6/11 16:36
 * @Description:
 */
public class Connection {

    public static void main(String[] args) {
        try {
            // 创建ZooKeeper实例
            ZooKeeper zk = new ZooKeeper("39.108.184.140:2181",100,null);
            String path = "/zk";

            //创建一个节点,模式是persistent
            zk.create(path,"1".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            System.out.println("创建节点"+path+",数据为："+new String(zk.getData(path,null,null)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

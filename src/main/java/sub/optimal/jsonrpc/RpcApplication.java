package sub.optimal.jsonrpc;

import com.googlecode.jsonrpc4j.spring.JsonServiceExporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sub.optimal.jsonrpc.api.MyService;
import sub.optimal.jsonrpc.impl.MyServiceImpl;

@SpringBootApplication
public class RpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpcApplication.class);
    }

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }

    @Bean(name = "/rpc/myservice")
    public JsonServiceExporter jsonServiceExporter() {
        JsonServiceExporter exporter = new JsonServiceExporter();
        exporter.setService(myService());
        exporter.setServiceInterface(MyService.class);
        return exporter;
    }
}

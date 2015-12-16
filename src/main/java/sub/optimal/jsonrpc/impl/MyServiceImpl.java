package sub.optimal.jsonrpc.impl;

import sub.optimal.jsonrpc.api.MyService;

public class MyServiceImpl implements MyService {

    @Override
    public String sayHelloWorld(String name) {
        return "Hello world, " + name;
    }
}

function fn() {

    var config = {};

    var env = karate.env; // get java system property 'karate.env'
    if (!env) {
        env = 'dev'; // a custom 'intelligent' default
        config.baseUrl = 'http://localhost:8036/api/admin/orderBoutique/';
        config.datasource = { username: 'root', password: '', url: 'jdbc:mysql://localhost:3306/peps-order', driverClassName: 'com.mysql.cj.jdbc.Driver' }
    }
    if (env == 'int') {
        // over-ride only those that need to be
        config.baseUrl = 'https://stage-host/api/admin/orderBoutique/';
        config.datasource = { username: '', password: '', url: '', driverClassName: 'com.mysql.cj.jdbc.Driver' } // TODO
    } else if (env == 'e2e') {
        config.baseUrl = 'https://e2e-host/api/admin/orderBoutique/';
        config.datasource = { username: '', password: '', url: '', driverClassName: 'com.mysql.cj.jdbc.Driver' } // TODO
    }

    common = karate.callSingle('classpath:common.feature', config);
    config.uniqueId = common.uniqueId
    config.db = common.db
    config.env = env;

    karate.log('karate.env =', karate.env);
    karate.log('config.baseUrl =', config.baseUrl);
    // don't waste time waiting for a connection or if servers don't respond within 5 seconds
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    return config;
}
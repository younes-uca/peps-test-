function fn() {

    var config = {};

    var env = karate.env; // get java system property 'karate.env'
    if (!env || env=='dev') {
        env = 'dev'; // a custom 'intelligent' default
        config.rootUrl = 'http://localhost:8036/';
        config.adminCredentials = {"username": "admin","password": "123"};
        config.datasource = { username: 'root', password: '', url: 'jdbc:mysql://localhost:3306/peps-order', driverClassName: 'com.mysql.cj.jdbc.Driver' }
    }
    if (env == 'int') {
        // over-ride only those that need to be
        config.rootUrl = 'https://stage-host/';
        config.adminCredentials = {"username": "","password": ""}; // TODO
        config.datasource = { username: '', password: '', url: '', driverClassName: 'com.mysql.cj.jdbc.Driver' } // TODO
    } else if (env == 'e2e') {
        config.rootUrl = 'https://e2e-host/';
        config.adminCredentials = {"username": "admin","password": ""}; // TODO
        config.datasource = { username: '', password: '', url: '', driverClassName: 'com.mysql.cj.jdbc.Driver' } // TODO
    }

    config.actuatorUri = config.rootUrl + 'actuator/';
    config.adminUri = config.rootUrl + 'api/admin/';
    config.orderBoutiqueUrl = config.adminUri + 'orderBoutique/';

    common = karate.callSingle('classpath:common.feature', config);
    config.uniqueId = common.uniqueId
    config.db = common.db
    config.adminToken = common.adminToken
    config.env = env;

    karate.log('karate.env =', karate.env);
    karate.log('config =', config);
    // don't waste time waiting for a connection or if servers don't respond within 5 seconds
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    return config;
}

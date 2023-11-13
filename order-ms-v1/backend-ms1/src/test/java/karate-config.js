function fn() {
    var config = {
      baseUrl: '',
    };
    config.uniqueId = karate.callSingle('classpath:common.feature', config).uniqueId;
    config.respLength = karate.callSingle('classpath:common.feature', config).respLength;

    // don't waste time waiting for a connection or if servers don't respond within 5 seconds
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    return config;
}

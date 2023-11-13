function fn() {
    if(typeof __num !== 'undefined' && __num == 0) {
        db.cleanUp();
        karate.log("db cleaned, __num:", __num);
    } else if (typeof __num == 'undefined') {
        db.cleanUp();
        karate.log("db cleaned");
    } // else don't clean db as it is a scenario of Outline
}

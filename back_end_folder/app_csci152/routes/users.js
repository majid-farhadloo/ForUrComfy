var express = require('express');
var mongoose = require('mongoose');
var router = express.Router();
var Schema = mongoose.Schema;

var userSchema = new Schema({
    email: String,
    passwd: String,
    created_date: {type: Date, default: Date.now()}
});

/* GET users listing. */
router.post('/login', function(req, res, next) {
   // validation
    if(! req.body.email) return res.json({"result": false, "message": "Email required"});
    if(! req.body.pswd) return res.json({"result": false, "message": "Password required"});

    // user check
});

module.exports = router;

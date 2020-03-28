import { Player,Action,TargetParams } from './player-declaration';

export const TARGETPARAMS = new TargetParams
     (
         1, //party 
         1, //self 
         0 //dead 
     )

export const ACTION = new Action
    (
        "attack", //name = name of attack
        0, //user 
        "warrior", //uName = name of character
        TARGETPARAMS, //targets 
        0, //amount 
        1, //astat 
        2, //dstat 
        0, //tstat 
        0, //element 
        0 //focus 
    )

export const PLAYER = new Player
    (
        0, //fid
        "warrior", //name 
         [30,15,10,5,5,5], //stats
        ACTION, //action 
        "Heroes", //party 
        false, //ready 
        [1]  //targets 
    )


// TargetParams JSON
// {"party" = 1, "self" = 1, "dead" = 0}

// Action JSON
// {
//     "name" = "attack",
//     "user" = 1,
//     "uName" = "warrior",
//     "targets" = {"party" = 1, "self" = 1, "dead" = 0},
//     "amount" = 0,
//     "astat" = 1,
//     "dstat" = 2,
//     "tstat" = 0,
//     "element" = 0,
//     "focus" = 0
// }

// Player JSON
// {
//     "fid" = 1,
//     "name" = "John",
//     "stats" = [30,15,10,5,5,5],
//     "action" = {
//          "name" = "attack",
//          "user" = 1,
//          "uName" = "warrior",
//          "targets" = [{"party" = 1, "self" = 1, "dead" = 0}],
//          "amount" = 0,
//          "astat" = 1,
//          "dstat" = 2,
//          "tstat" = 0,
//          "element" = 0,
//          "focus" = 0
//      },
//     "party" = "Heroes",
//     "ready" = false,
//     "targets" = [1]
// }

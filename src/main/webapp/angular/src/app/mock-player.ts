import { Player,Action,TargetParams,Stats, Dto } from './player-declaration';

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
        TARGETPARAMS, //targets 
        0, //amount 
        1, //astat 
        2, //dstat 
        0, //tstat 
        0, //element 
        0, //focus 
        "warrior" //uName = name of character
    )


export const STATS = new Stats
    (
        5, //hp: number,
        5, //atk: number,
        5, //def: number,
        5, //matk: number,
        5, //mdef: number,
        5, //spd: number,
        5, //acc: number,
        5, //evd: number,
        5, //crit: number,
        5, //chr: number,
        5 //dex: number
    )


export const PLAYER = new Player
    (
        0, //id
        0, //fid
        "warrior", //name 
        STATS, // [15,10,5,1,1,1], //stats; input the class STATS not the array.
        ACTION, //action 
        "Heroes", //party 
        false, //ready 
        [1],  //targets 
        true //alive
    )

export const PLAYER1 = new Player
    (
        0, //id
        0, //fid
        "warrior", //name 
        STATS, // [15,10,5,1,1,1], //stats; input the class STATS not the array.
        ACTION, //action 
        "Heroes", //party 
        false, //ready 
        [1],  //targets 
        true //alive
    )
export const DTO = new Dto
(
    [PLAYER],
    0,
    "New Entry"
)
export const PLAYER2 = new Player
    (
        0, //id
        0, //fid
        "warrior", //name 
        STATS, // [15,10,5,1,1,1], //stats; input the class STATS not the array.
        ACTION, //action 
        "Heroes", //party 
        false, //ready 
        [1],  //targets 
        true //alive
    )

export const PLAYER3 = new Player
    (
        0, //id
        0, //fid
        "warrior", //name 
        STATS, // [15,10,5,1,1,1], //stats; input the class STATS not the array.
        ACTION, //action 
        "Heroes", //party 
        false, //ready 
        [1],  //targets 
        true //alive
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

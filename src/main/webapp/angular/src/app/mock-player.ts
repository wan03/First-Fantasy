import { Player,Action,TargetParams } from './player-declaration';

export const PLAYER = new Player
    (
        1, //fid
        "John", //name 
         [1], //stats
        this.ACTION, //action 
        "party", //party 
        true, //ready 
        [0]  //targets 
    )

export const ACTION = new Action
    (
        "John", //name 
        1, //user 
        "John1", //uName 
        this.TARGETPARAMS, //targets 
        1, //amount 
        1, //astat 
        1, //dstat 
        1, //tstat 
        1, //element 
        1 //focus 
    )

 export const TARGETPARAMS = new TargetParams
     (
         1, //party 
         1, //self 
         0 //dead 
     )
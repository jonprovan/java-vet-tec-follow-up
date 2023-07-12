import { LeadActor } from "./lead-actor";
import { LeadActress } from "./lead-actress";

export class Movie {

    movieId: number;
    name: String;
    genre: String;
    releaseYear: number;
    leadActor: LeadActor;
    leadActress: LeadActress;
    boxOfficeGross: number;
    imageUrl: String;
    imdbUrl: String;

    constructor(movieId: number,
                name: String,
                genre: String,
                releaseYear: number,
                leadActor: LeadActor,
                leadActress: LeadActress,
                boxOfficeGross: number,
                imageUrl: String,
                imdbUrl: String) {
                    this.movieId = movieId;
                    this.name = name;
                    this.genre = genre;
                    this.releaseYear = releaseYear;
                    this.leadActor = leadActor;
                    this.leadActress = leadActress;
                    this.boxOfficeGross = boxOfficeGross;
                    this.imageUrl = imageUrl;
                    this.imdbUrl = imdbUrl;
    }

}

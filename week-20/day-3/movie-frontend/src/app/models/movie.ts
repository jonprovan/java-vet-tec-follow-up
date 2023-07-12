import { LeadActor } from "./lead-actor";
import { LeadActress } from "./lead-actress";

export class Movie {

    movieId: number;
    name: string;
    genre: string;
    releaseYear: number;
    leadActor: LeadActor;
    leadActress: LeadActress;
    boxOfficeGross: number;
    imageUrl: string;
    imdbUrl: string;

    constructor(movieId: number,
                name: string,
                genre: string,
                releaseYear: number,
                leadActor: LeadActor,
                leadActress: LeadActress,
                boxOfficeGross: number,
                imageUrl: string,
                imdbUrl: string) {
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

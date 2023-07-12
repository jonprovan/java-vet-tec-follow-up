export class LeadActress {

    leadActressId: number;
    name: String;
    age: number;
    academyAwards: number;
    imageUrl: String;
    imdbUrl: String;

    constructor(leadActressId: number,
                name: String,
                age: number,
                academyAwards: number,
                imageUrl: String,
                imdbUrl: String) {
                    this.leadActressId = leadActressId;
                    this.name = name;
                    this.age = age;
                    this.academyAwards = academyAwards;
                    this.imageUrl = imageUrl;
                    this.imdbUrl = imdbUrl;
                }
}

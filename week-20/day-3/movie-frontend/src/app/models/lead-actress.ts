export class LeadActress {

    leadActressId: number;
    name: string;
    age: number;
    academyAwards: number;
    imageUrl: string;
    imdbUrl: string;

    constructor(leadActressId: number,
                name: string,
                age: number,
                academyAwards: number,
                imageUrl: string,
                imdbUrl: string) {
                    this.leadActressId = leadActressId;
                    this.name = name;
                    this.age = age;
                    this.academyAwards = academyAwards;
                    this.imageUrl = imageUrl;
                    this.imdbUrl = imdbUrl;
                }
}

package com.example.petapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Class meant to be called and that helps intialise the db by returning an array of pets and foods.
 * The arraylists returned can be used by the parent class by calling the db insert all function on said arraylists
 * @author UP915469
 */
public class DBHelper {
    List<Pet> pets = new ArrayList<>();
    List<Food> foods = new ArrayList<>();

    public List<Pet> initialisePets(){
        pets.add(new Pet("Beagle", "Dog", "beagle", "12-15 years", "Male: 10-11kg, Female: 9-10kg", "" +
                "Beagles are great family pets but due to their strong hunting instincts they might not be the best dogs for homes with smaller pets. Beagles tend to be very tolerant and accepting by nature and so will fit into family life perfectly if well socialised from a young age.\n" +
                "\n" +
                "Their size and affectionate personalities make Beagles a popular family pet but they can be quite high energy so always supervise your Beagle with children. Like any dog, they can be destructive when bored so make sure to keep their mind active with training and lots of exercise.",
                "Beagles can be mischievous characters so it’s important to start positive, reward-based training as soon as possible to prevent them picking up bad habits. They are very intelligent dogs and are known to be wilful so you will need a firm but fair attitude when training – as always, consistency is key. " +
                "If you aren’t an experienced trainer, or are a first-time dog owner, then you should ask for the help of an accredited trainer.",
                "Beagles tend to be quite high energy and you’ll find they enjoy being part of everything their owners do. Whether you live in a city or the countryside, your Beagle will still need plenty of exercise to keep them happy and healthy. Beagles are good escape artists and love to climb and dig, so make sure your garden is Beagle-proof!\n" +
                "\n" +
                "Your Beagle will need at least an hour and a half of exercise a day. We’d recommend a combination of walking and running for this. In addition, they’ll also need playtime, training and free time in a secure garden. Beagles are scent hounds, so they’ll really enjoy playing scent games with you and getting the chance to use their keen sense of smell.",
                1, 2, 3));
        pets.add(new Pet("Bulldog", "Dog", "bulldog", "8-10 years","Male: 23-25kg, Female: 18-23kg", "" +
                "Bulldogs are sweet, devoted, and easygoing, and they want to please their owner. As with all breeds, early socialization is vital to help give the dog a good start in life. Puppy training classes are highly recommended as well and allow the owner to learn how to curb any undesirable behaviors. Bulldogs love to chew—most will enjoy chew toys their entire life. ",
                "Bulldogs are mellow and are happy to relax next to their owner’s feet, but they also enjoy an occasional romp and going on walks. Moderate exercise will help the dog to stay trim. Very warm days are best spent in front of an air-conditioner, however, as the Bulldog’s short muzzle can make breathing difficult in heat and humidity." +
                 " Stairs and pools also present major safety hazards. ",
                "An all-over brushing with a soft brush for 10 minutes two or three times a week will keep the Bulldog looking his best. During periods of heavier shedding, it can help to first use a rubber curry brush. The wrinkles on the Bulldog’s face need to be regularly checked to make sure the skin is clean and dry, as food or moisture can get trapped and cause irritation or infection.",
                2,3,4));
        pets.add(new Pet("Golden Retriever", "Dog", "golden", "10-12 years", "Male: 30-34kg, Female: 25-32kg", "Golden retrievers have an outgoing, devoted, and friendly personality, making this type of dog a great addition to any family. They maintain a playful and energetic approach to life longer than some other breeds, so be ready to play lots of " +
                "fetch with your golden retriever!",
                "Golden retrievers are also incredibly intelligent and eager to please, which makes them easy to train. Basic obedience and house-training skills, including potty training and not digging, should be taught when your golden retriever is a puppy. With more advanced training, golden retrievers can serve as guide dogs for the blind, rescue dogs, and hunting dogs.",
                " Golden retrievers need plenty of exercise; they love playing outdoors and swimming. As far as care, the golden retriever has a thick, water-repellent double-coat, which can be wavy or straight. Its coat needs to be brushed twice a week to help control shedding. Golden retrievers have strong, fast-growing nails that require regular trimming or grinding to prevent overgrowth, splitting, and cracking. ",
                1,3,4));
        pets.add(new Pet("Shiba Inu", "Dog", "shiba", "12-15 years", "Male: 8-11kg, 6.8-9kg", "Considered highly trainable and easier to housebreak, you won’t find many troubles with the Shiba Inu. It can be stubborn at times, because of its confidence and strong instincts, but if you demonstrate that you’re the pack leader, there should be no problems keeping your dog on a strict discipline program.",
                "The most common health problems of the Shiba Inu relate to joint problems, which is not rare for dogs but a little unusual for dogs of its size. You might even notice kneecap problems in this dog, not a common problem in other dogs.",
                "Though small, the Shiba Inu has a surprising thirst for some forms of exercise and will be able to catch up with you easily if you take it out often. Regular walking should be considered a normal habit, and certainly something you’ll want to get into with any dog. The breed might also want to get away from you at times to explore natural landscapes.",
                1,2,3));
        pets.add(new Pet("Dobermann", "Dog", "dober", "10-13 years", "Male: 40-45kg, Female: 32-35kg", "Keep your Doberman indoors during cold weather, as he can chill easily because of his short coat. Purchase a dog sweater or coat for him when walking him in cold conditions.\n" +
                "Give your Doberman interactive toys, such as treat-containing chew toys, to engage his mind during the day when you are not home. This prevents destructive behavior in this breed from developing.",
                "Take your Doberman for regular vet visits to check for certain conditions that are more prevalent in this breed including cancer, hyperthyroidism, hip dysplasia, Von Willebrand's disease and dilated cardiomyopathy.", "" +
                "If you cannot play with or exercise your Doberman outdoors as much as he needs, run him on a treadmill to ensure he gets the exercise he needs to prevent compulsive or destructive behaviors.\n" +
                "Socialize your Doberman from an early age to prevent any issues with aggression later in life toward other people or dogs. Have your young Doberman play with other dogs and expose him to a variety of other people starting at 12 weeks old.\n" +
                "This intelligent, obedient dog can be trained to be a guide dog for the blind with a certified guide dog instructor.",
                1, 2,3));
        pets.add(new Pet("Cocker Spaniel", "Dog", "cocker_spaniel", "12-15 years", "20-30 pounds", "The Cocker Spaniel has a sweet temperament. He is affectionate and cuddly and loves to participate in family activites. He is playful, alert, and active, enjoying any exercise from a brisk walk to hunting in the field. The Cocker is known to be a sensitive dog, mentally and physically",
                "While the Cocker Spaniel is on the small side, don’t forget that he is a Sporting breed. Although he doesn’t need the hard-core exercise of some of the other sporting breeds, he still needs to burn off a lot of steam as he could run all day – after all, he’s bred to do so. However, a half hour walk or game of fetching the ball once or twice a day is appropriate, although he’d love to go on longer walks with you. You could also substitute a solid 15 minutes per day of obedience training, which stimulates his mind as well as his body. He’s a busy little guy, sniffing all day to follow a scent.",
                "If you want the flowing long coat, more care and time must be taken, and typically the bathing, brushing and trimming happens once a week. Most people choose to take their Cocker to a professional groomer," +
                        "but you can learn to do it yourself. The cost of the equipment is equivalent to only a few grooming sessions, you won’t have to schedule appointments and you will find that you increase your bond with your Cocker. However, grooming isn’t for everyone, so if you don’t want to do it, find a groomer you like because it’s an absolute requirement for a Cocker.",
                1,2,3));
        pets.add(new Pet("Persian", "Cat", "persian", "10-17 years", "7-12 pounds", "Most cats stay relatively clean and rarely need a bath, but you should brush or comb your cat regularly. Frequent brushing helps keep your cat's coat clean, reduces the amount of shedding and cuts down on the incidence of hairballs.",
                "To pick up your cat, place one hand behind the front legs and another under the hindquarters. Lift gently. Never pick up a cat by the scruff of the neck or by the front legs.",
                "Your pet should have her own clean, dry place in your home to sleep and rest. Line your cat's bed with a soft, warm blanket or towel. Be sure to wash the bedding often. Please keep your cat indoors. Outdoor cats do not live as long as indoor cats. Outdoor cats are at risk of trauma from cars, or from fights with other cats, raccoons and free-roaming dogs. ",
                5,6,7));
        pets.add(new Pet("Bengal", "Cat", "bengal", "14-16 years", "10-15 pounds", "Most cats stay relatively clean and rarely need a bath, but you should brush or comb your cat regularly. Frequent brushing helps keep your cat's coat clean, reduces the amount of shedding and cuts down on the incidence of hairballs.",
                "To pick up your cat, place one hand behind the front legs and another under the hindquarters. Lift gently. Never pick up a cat by the scruff of the neck or by the front legs.",
                "Your pet should have her own clean, dry place in your home to sleep and rest. Line your cat's bed with a soft, warm blanket or towel. Be sure to wash the bedding often. Please keep your cat indoors. Outdoor cats do not live as long as indoor cats. Outdoor cats are at risk of trauma from cars, or from fights with other cats, raccoons and free-roaming dogs. ",
                5,6,7));
        pets.add(new Pet("Siamese", "Cat", "siamese", "15-20 years", "10-13 pounds", "Most cats stay relatively clean and rarely need a bath, but you should brush or comb your cat regularly. Frequent brushing helps keep your cat's coat clean, reduces the amount of shedding and cuts down on the incidence of hairballs.",
                "To pick up your cat, place one hand behind the front legs and another under the hindquarters. Lift gently. Never pick up a cat by the scruff of the neck or by the front legs.",
                "Your pet should have her own clean, dry place in your home to sleep and rest. Line your cat's bed with a soft, warm blanket or towel. Be sure to wash the bedding often. Please keep your cat indoors. Outdoor cats do not live as long as indoor cats. Outdoor cats are at risk of trauma from cars, or from fights with other cats, raccoons and free-roaming dogs. ",
                5,6,7));
        pets.add(new Pet("Pug", "Dog", "pug", "12-14 years", "14-18 pounds", "Round head, square body, curly tail — that’s the Pug. Wherever he goes, his wrinkly face and fun-loving personality charm people. He is good with other dogs, cats, and children, and nothing makes him happier than being part of the family. He’s no jogging buddy, but this lively fellow loves an outing to the office or park.",
                "If you’re careful to mind his special needs, the Pug is an easy-care pet. His short coat sheds, but his grooming needs are modest. He doesn’t need a great deal of exercise — nor can he tolerate it — but it’s important to keep him lean, fit, and mentally challenged, especially when he’s young. Because of his great love for people, care should be taken to accustom your Pug to being alone so he doesn’t develop excessive anxiety when left behind.",
                "Grooming a Pug’s coat is easy. Brush his smooth double coat weekly with a rubber curry brush to remove dead hair. And you will remove lots of it, because Pugs shed. A lot. They shed year-round, so it’s something you should expect to live with.",
                1, 2, 3));
        pets.add(new Pet("Ball Python", "Snake", "bull_python", "25-30 years", "4-5 pounds", "A well-balanced ball python diet consists of appropriately sized frozen rodents, thawed/warmed to above room temperature.Feed juveniles once a week, adults every one to two weeks.",
                "Habitat maintenance, Thoroughly clean and disinfect the habitat at least once a week: place snake in a secure habitat; scrub the tank and furnishings with a 3% bleach solution; rinse thoroughly with water, removing all traces of bleach smell; dry the tank and furnishings completely and add clean substrate.",
                "Grooming & hygiene, Snakes will regularly shed their skin; ensure humidity of habitat is at appropriate level to allow snake to shed properly.Never try to remove eye caps by yourself. Seek veterinary care.",
                8, 9, 10));
        pets.add(new Pet("Crested Gecko", "Gecko", "crested_gecko", "15-20 years", "40-60 grams", "Crested geckos are originally from New Caledonia (a group of islands between Fiji and Australia). Crested geckos are ideal reptile pets for beginners, with simple, easy- to-meet requirements. Because crested geckos are primarily tree dwellers, they make outstanding displays in naturalistic vivariums.",
                "Baby crested geckos are best housed in large plastic terrariums or in standard (20-inch) 10-gallon reptile tanks with a screen top. An adult crested gecko should be housed in a 20-gallon tank with screen top. Larger tanks will allow for better displays. In areas with moderate to high relative humidity, crested geckos will fare well in screen cages. These tanks have the advantage of being light and easy to clean. You can keep one male and several female crested geckos together. Male crested geckos may fight, particularly when in the company of females, and should not be kept together.",
                "Water should always be available for crested geckos in a shallow water dish. These geckos also require a relative humidity of at least 50 percent and preferably 70 percent. In dry areas the tanks should be lightly misted nightly or a cool air humidifier placed in the room. Inexpensive hygrometers (relative humidity gauges) for use with reptiles are now readily available in the pet trade.",
                11, 12, 13));
        return pets;
    }

    public List<Food> initializeFood(){

        foods.add(new Food("Butcher's Loaf Recipes", "butchers", "Tesco", "Morrisons", "Pets at Home",
                "Butchers: Meals rich in all the nutrients your dog needs.\n" +
                        "No Nasties, No artificial colours, flavours or preservatives, Wholegrain Rice, Easy to digest, high in fibre and naturally gluten free, Garden Veg\n" +
                        "Great fibre source and packed with vitamins, Beneficial Oils, Omega 3 and 6 for healthy skin and coat"));
        foods.add(new Food("Pedigree Pouch Real Meals", "pedigree", "Tesco", "Morrisons", "Sainsburys",
                "Pedigree: Easy-to-open individual packets, ideal for a fresh healthy meal, on its own or on top of dry canine food\n" +
                        "Nutrition for dogs that helps support healthy bones, good digestion, a healthy skin & coat and strong natural defenses"));
        foods.add(new Food("Winalot Sunday Dinner ", "winalot", "Pets at Home", "Morrisons", "Sainsburys",
                "Winalot: Made with succulent meaty chunks and quality ingredients.\n" +
                        "It contains all the essential vitamins and minerals your dog needs to ensure every bowl of Winalot is 100% Complete and balanced."));
        foods.add(new Food("Cesar Tray Country Kitchen", "cesar", "Tesco", "Pets at Home", "Sainsburys",
                "Cesar: Quality pet food made with carefully selected ingredients\n" +
                        "Delicious dog food recipes made with no added sugars, no artificial colours or flavour"));
        foods.add(new Food("Purina One Adult Dry Cat Food", "purina", "Tesco", "Morrisons", "Pets at Home",
                "Purina: contains, along with the beneficial functional bacteria, all the key nutrients your cat needs, including Omega 6 fatty acids.\n" +
                        "Its dual defence formula works in parallel on the inside, by helping to support your cat's natural antibody production, and on the outside by maintaining healthy skin and coat."));
        foods.add(new Food("Felix As Good As It Looks", "felix", "Tesco", "Morrisons", "Sainsburys",
                "Felix: 100% of your cat's daily needs, Irresistible meals for mischief makers, Vitamins D & E, Balanced minerals, Source of omega 6"));
        foods.add(new Food("Gourmet Mon Petit Fish", "gourmet", "Pets at Home", "Morrisons", "Sainsburys",
                "Gourmet: 100% complete and balanced nutritional pet food for adult cats (aged 1 to 7), Packed with essential vitamins and minerals to keep your adult cat healthy"));
        foods.add(new Food("Small frozen mice", "small_mice", "Pets at Home", "Online retailer", "Indipendent store",
                "Protein 16%, Fat 6-7%"));
        foods.add(new Food("Regular frozen mice", "small_mice", "Pets at Home", "Online retailer", "Indipendent store",
                "Protein 20%, Fat 4-8%"));
        foods.add(new Food("Mouse Pinks", "mouse_pinks", "Pets at Home", "Online retailer", "Indipendent store",
                "Protein 12%, Fat 27%"));
        foods.add(new Food("Brown Crickets", "brn_crickets", "Pets at Home", "Online retailer", "Indipendent store",
                "These big, meaty live brown crickets for reptile food are produced fresh on our Somerset based farm and are essential to ensure a staple diet for many reptiles. Very popular food for various Lizards including bearded dragons, Leopard Geckos, Frogs and Water dragons. By choosing to feed your reptile livefoods such as these crickets you will be promoting a natural hunting, stalking and waiting behaviour from your reptile which keeps him/her active and occupied and is more what they would be accustomed to in the wild."));
        foods.add(new Food("Repashy Superfoods Crested Gecko Diet", "cgd", "Pets at Home", "Online retailer", "Indipendent store",
                "Complete Diet"));
        foods.add(new Food("Waxworms", "waxworms", "Pets at Home", "Online retailer", "Indipendent store",
                "Moisture - 59.8%\n" +
                        "Fat - 15.2%\n" +
                        "Calcium - 0.02%\n" +
                        "Protein - 19.5%\n" +
                        "Calcium/Phosphorus Ratio - 0.10%"));
        return foods;
    }

}

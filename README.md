# PlantsVsZombies

## Interfaces Required:
1. Attacking (for Plant, Zombie)
2. Hiding (for Plant)
3. Clonable (for Zombie, Projectile)
4. Plantable (for Plant (lilypad, flowerpot), Tile)
5. Growable (for Plant)
6. DayTime (tagging)
7. NightTime (tagging)
8. Suntype
9. Freezing

## Basic Classes Required:
1. Plants (abstract)
    - HP
    - XP defining size
    - Attack_value
    - Position
    - Wait_time
    - Range
    - Attack_Interval
    - Plant() method
2. Plant_Type (extends Plants)
    - Additional HP
    - Additional Attack
    - implements Attacking?
    - implements Hiding?
    - implements Growable?
    - implements Suntype?
    - implements Freezing?
    - implements DayTime/NightTime/both?
    - implements Plantable?
    - (Image) plantAppearance
    - Projectile (if Attacking)
    - Plant() method (partial overriding)
3. Zombies (abstract)
    - implements Attacking
    - Attack_value
    - Position
    - Attack_interval
    - Attack() method
    - Move() method
    - isAttacked() method
4. Zombie Type
    - HP
    - implements Clonable?
    - (Image) zombieAppearance
5. Tile
6. Tile Type
    - implements Plantable?
    - (image) tileAppearance
    - Plant object (if Plantable)
    - Plant() method (in Plantable)
7. Game
    - Tile[][] Play Area
    - Plants[][] toPlantOnTile
    - Zombies[] to come
    - Inner Class Sidebar
    - Inner Class Zombies left progress bar
    - playGame() method
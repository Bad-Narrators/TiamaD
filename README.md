# TiamaD

The scope of the project is creating a platform for streamers that gives plenty of functionalities to the users. 

This platform aims to simplify in a modular package everything a new streamer might need, initially referencing the requirements for the group "Dragons in Your DMs".

---

##Structure

The base structure is as follows:

- **TiamaD** (or **TiamaD-Skel**) - The core of the platform, it functions as the framework linking all the other services together via RESTful calls.
- **TwitchamaD** - Manager of the Twitch API and everything concerning logic directly attached to Twitch.
- **TiamaDiscord** - Manager of the Discord API and everything concerning logic directly attached to Discord.
- **TiamaD-Tail** - Backend service, whose main features regard communicating with any DB the platform needs to connect to.
- **TiamaD-Fangs** - Frontend service, mainly a manager for the website that will be supported by the platform.

---

##Functionalities

- Ban/kick bot for Twitch and Discord
- Poll creator, manager and visualizer
- Events creator, manager and visualizer

    - Stream schedule
    - In-game chat gambling
    - Polls
    - MVP event scheduler

- Discord commands directly connected to Twitch channel

    - Admin commands
    - Create, manage, share and show polls
    - Start events

- Crowd MVP/Inspiration (`the viewers will be able to spam reactions/emoticons/commands/character names, whose will be counted and after a certain amount in a set time everyone will be alerted and an MVP/Inspiration will be awarded`)

- Crowd dice rolls

- Viewers suggestions (`those regard various topics that will be split both in functionalities and categories, for example NPC suggestions, stream quality suggestions, feature suggestions, bot suggestions, etc.`)

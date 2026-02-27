# Git Introduction
This project will guide you through some of the more common features of Git that are used for project development. More specifically, we will be focusing on remotes, pushing/pulling, and branches.

## Forking the Intro Project Repository and Cloning it Down Locally

1. Visit https://github.com/som1shi/sp26-plextech-fswd-intro-projects
2. On the main page, click the fork button on the upper right hand corner that should take you to the "Create a new fork" page
3. Make sure the Owner is your Github account and then click the green "Create fork" icon
4. Navigate back to the main page oF YOUR NEW FORKED REPOSITORY and click the green "<> Code" icon
5. Click the copy link icon for under the HTTPS tab to copy the link for your forked repo
6. Type the following commands in a new folder on your local machine. This will be the folder where you store your projects:
    1. `git clone <link-copied-in-step-5>`

You should now be able to see the starter code that we currently have available locally.

## Pushing/Pulling

NOTE: For the rest of this project you will be working in pairs to simulate the code collaboration experience. Assign someone to be Person A and the other to be Person B. MAKE SURE that you work side-by-side to see all parts of the Git process.

### PART 1 - Person B only

Clone down Person A's repository (MAKE SURE PERSON B HAS INVITED YOU TO THE GIT REPO FIRST!) by visiting their forked Github link for their intro projects and following the same instructions for cloning:

1. Navigate back to Person A's forked main page and click the green "<> Code" icon
2. Click the copy link icon for under the HTTPS tab to copy the link for your forked repo
3. On your terminal/bash, create a new folder anywhere outside of your forked repo.
4. Type the following commands in a new folder on your local machine.
    1. `git clone <link-copied-in-step-2>`

 For the rest of this project, we will be working in Person A's "Git Intro" project folder path. Type `git log` and save a screenshot in this folder.

When working on projects, you are going to be constantly pushing and pulling code to update/get updates from your repos. Let's push the screenshot that we just created to our repository.
A "commit" is a list of changes that is stored by git. Committing only affects your local Git record.

1. Type `git status` to see the new change created by your added image. It should be called `Git Intro/<IMAGE-NAME-1>`
2. Type `git add Git Intro/<IMAGE-NAME-1>` to stage the file.
3. Type `git commit -m "image added"` to commit your change.
4. Type `git push origin main` to push your changes to the main branch.

Now when you navigate to the repository on your Github, you should see all the starter code along with your screenshot in the "Git Intro" project folder. If your friend wanted to work with you on a project (like a [group project](https://github.com/som1shi/sp26-plextech-fswd-intro-projects)), they would need to `git pull` the changes whenever you update the repository on your end to avoid any major merge conflicts.

### PART 2 - Person A ONLY

Lets try doing the same workflow that Person B did: 

We will be working in Person A's "Git Intro" project folder path. Type `git log` and save a screenshot in this folder.

When working on projects, you are going to be constantly pushing and pulling code to update/get updates from your repos. Let's push the screenshot that we just created to our repository.
A "commit" is a list of changes that is stored by git. Committing only affects your local Git record.

1. Type `git fetch --all` to make sure your local version of the remote main branch is updated
2. Type `git status` to see the new change created by your added image. It should be called `Git Intro/<IMAGE-NAME-2>`
3. Type `git add Git Intro/<IMAGE-NAME-2>` to stage the file.
4. Type `git commit -m "image added"` to commit your change.
5. Type `git push origin main` to push your changes to the main branch.

Whoops! You hopefully got some error message along the lines of "Updates were rejected because the remote contains work that you do not have locally." This means that your local version of the LOCAL main branch does not have the changes that Person B pushed up earlier, so we can't push our changes until we take Person B's changes in first. All we have to do is:

1. Type `git pull origin main` to pull changes from the remote main branch from Person B into the local main branch.
2. Type `git push origin main` to push your changes to the main branch. There should be no errors this time!

## Branching
Typically when you are working on a larger project with multiple developers, you will be working on a separate branch specific to the feature that you are responsible for. This allows for independent lines of development, as new additions can be made to the main repository without pushing unfinished code from another feature. Let's use this feature for the last part of this project.

### Part 3 - Person B ONLY

Suppose one of your project partners created `foo.py` with a function that prints "Foo" if the input is a multiple of 3 and "Bar" otherwise. However, you found that the function only works with positive numbers up to 30. Your job is to fix this bug while your partner is working on another feature.

1. First type "git pull origin main" to get Person A's latest change in
2. Create and checkout a new branch with `git checkout -b bug-fix`. If you type `git branch` you should see your new branch with a * next to it to indicate that is your current working branch.
3. Fix the function in `foo.py` so that it works as intended.
4. Add and commit your changes.
5. Type `git push origin bug-fix` to push your changes to the new branch that you created.

### Part 4 - Person A ONLY

Person B has fixed the bug in the code, but now what? These changes are still in your bug-fix branch, while the issue is still not resolved on main. What we want to do is merge the fixes in our current branch into the main branch of our repository. We can do so through a pull request.

1. On your Github repository, click on "pull requests" and then "new pull request." Select your bug-fix branch as the compare branch and click "create pull request" (make sure main is the base branch). Here, reviewers can comment on the changes that you've made and approve the pull request before it gets merged into the main codebase.
2. Add a comment onto the pull request (like a "LGTM" or something quirkier!??!)
3. Click "merge pull request" and confirm the merge.

Now you should be able to see your changes on main.

Click [here](https://www.atlassian.com/git/tutorials/using-branches) for more information on branching.

## Conclusion

*Submission info and other stuff

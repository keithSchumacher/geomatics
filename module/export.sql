USE module_database
INSERT INTO moduleOutput(module_name, commit_hash, commit_author, commit_message) 
VALUES("$_repo_name", "$git_hash", "$git_author", "$git_message");

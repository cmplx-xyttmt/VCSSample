import re

# read artifact_url file
def read_url_file():
    url_file = open("artifact_url", "r")
    if url_file.mode == "r":
        return url_file.read()


# extract path and store in artifact_path file
def create_path_file():
    url = read_url_file()
    print "============ url: ", url, "============="
    file_path = re.sub(r"(?<=)(.*)(?=test)", "", url)
    print "============ path: ", file_path, "========="
    path_file = open("artifact_path", "w+")
    if path_file.mode == "w+":
        path_file.write(file_path)
        path_file.close()

if __name__ == "__main__":
    create_path_file()

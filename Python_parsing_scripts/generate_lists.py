import sys
from collections import defaultdict


FILES_TYPE = ".csv"
FILES_DIRECTORY = "/Users/allenyu/workspaces/schedule/csv_raw/"
FILES_PARSED_DIRECTORY = "/Users/allenyu/workspaces/schedule/csv_parsed/"
FILES_SCHEDULE_TAG = "_schedule_object"
FILES_COMPANY_TAG = "_company_object"
FILES_STUDENT_TAG = "_student_object"


def main(args):
    args.pop(0)
    for file_name in args:
        create_files(file_name)


def create_files(file_name):
    # generate_schedule(file_name)
    generate_company(file_name)
    # generate_student(file_name)


def generate_schedule(file_name):
    file = open(create_input_file_name(file_name), "r")
    result = open(create_output_file_name(file_name, FILES_SCHEDULE_TAG), "w")
    day_counter = 1
    slot_counter = 0
    start = True
    for line in file:
        if ":" not in line:
            if not start:
                result.write(str(slot_counter) + "\n")
            company_array = line.split(",")
            company_array.pop(0)    #Remove date
            result.write(str(day_counter+1) + "|")
            slot_counter = 0
            day_counter += 1
            start = False
        else:
            slot_counter += 1
    result.write(str(slot_counter) + "\n")
    result.close()
    file.close()


def generate_company(file_name):
    file = open(create_input_file_name(file_name), "r")
    result = open(create_output_file_name(file_name, FILES_COMPANY_TAG), "w")
    company_dict = defaultdict(list)
    companies = []
    slot_counter = 0
    pass_length = 0
    day_counter = 0
    start_counter = 0
    for line in file:
        if ":" not in line:
            company_array = line.split(",")
            company_array.pop(0)
            start_counter += len(companies) - pass_length
            pass_length = len(companies)
            for company in company_array:
                clean_string_company = company.rstrip().lstrip()
                if clean_string_company:
                    companies.append(clean_string_company)
            slot_counter = 0
            day_counter +=1
        else:
            appointments = line.split(",")
            for i in range(1, len(appointments)):
                if appointments[i].rstrip().lstrip():
                    company_key = companies[start_counter+i-1]
                    company_dict[company_key].append(str(day_counter) + "," + str(slot_counter))
            slot_counter += 1

    result.close()
    file.close()


def generate_student(file_name):
    file = open(create_input_file_name(file_name), "r")
    result = open(create_output_file_name(file_name, FILES_STUDENT_TAG), "w")
    result.close()
    file.close()


def create_input_file_name(file_name):
    return FILES_DIRECTORY + file_name + FILES_TYPE


def create_output_file_name(file_name, tag):
    return FILES_PARSED_DIRECTORY + file_name + tag + FILES_TYPE


if __name__ == "__main__":
    main(sys.argv)
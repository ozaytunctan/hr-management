import { environment } from "src/environments/environment";

export const ApiUrlConstant={

    API_HOST:environment.API_SERVER_HOST,

    EMPLOYEE:{
        GET_EMPLOYEE_BY_ID_URL:`${environment.API_SERVER_HOST}/employee`,

        GET_ALL_EMPLOYEE_URL:`${environment.API_SERVER_HOST}/employee/all`,

        CREATE_EMPLOYEE_URL:`${environment.API_SERVER_HOST}/employee/add`,

        DELETE_EMPLOYEE_BY_ID_URL:`${environment.API_SERVER_HOST}/employee/delete`,

        UPDATE_EMPLOYEE_BY_ID_URL:`${environment.API_SERVER_HOST}/employee/update`,
    }


}
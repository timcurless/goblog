package model

type Account struct {
	Id string `json:"id"`
	Name string `json:"name"`
	Quote Quote `json:"quote"`

	// For Load Balancing Testing
	ServedBy string `json:"servedBy"`
}

type Quote struct {
	Text string `json:"quote"`
	ServedBy string `json:"ipAddress"`
	Language string `json:"language"`
}

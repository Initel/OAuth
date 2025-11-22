function App() {
  return <main className="d-flex justify-content-center align-items-center vh-100 bg-light">
      <div className="container text-center">
        <div className="d-grid gap-2 col-4 mx-auto">
          <a
            className="w-100 btn btn-lg btn-primary"
            href="http://localhost:3000/oauth2/authorization/keycloak"
            role="button"
            style={{ marginTop: "10px" }}
          >
            Login
          </a>
        </div>
      </div>
    </main>
}

export default App
